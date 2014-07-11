package org.foam.transform.ucm2ucm;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;
import com.google.common.base.Objects;
import com.google.common.base.Splitter;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.foam.annotation.Annotation;
import org.foam.annotation.AnnotationFactory;
import org.foam.annotation.UnknownAnnotation;
import org.foam.transform.ucm2ucm.AnnotatedText;
import org.foam.transform.ucm2ucm.BranchingLabeledAnnotatedText;
import org.foam.transform.ucm2ucm.BranchingType;
import org.foam.transform.ucm2ucm.IdAndName;
import org.foam.transform.ucm2ucm.LabeledAnnotatedText;
import org.foam.ucm.Scenario;
import org.foam.ucm.ScenarioHolder;
import org.foam.ucm.Step;
import org.foam.ucm.UcmFactory;
import org.foam.ucm.UseCase;
import org.foam.ucm.UseCaseModel;
import org.osgi.service.log.LogService;

@Component(provide = UcmLang2UcmService.class)
@SuppressWarnings("all")
public class UcmLang2UcmService {
  private LogService logService;
  
  @Reference
  public void setLogService(final LogService logService) {
    this.logService = logService;
  }
  
  private void info(final CharSequence message) {
    String _string = message.toString();
    this.logService.log(LogService.LOG_INFO, _string);
  }
  
  private final UcmFactory usecaseFactory = UcmFactory.eINSTANCE;
  
  private final AnnotationFactory annotationFactory = AnnotationFactory.eINSTANCE;
  
  private final String PRECEDING = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Preceding:");
      return _builder.toString();
    }
  }.apply();
  
  private final String PRIMARY = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Primary:\\s+(\\w+)");
      return _builder.toString();
    }
  }.apply();
  
  private final String ANNOTATION_REGEXP = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("#\\(([^)]*)\\)");
      return _builder.toString();
    }
  }.apply();
  
  private final String UC_REGEXP = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("(UC\\d+)[:.]?");
      return _builder.toString();
    }
  }.apply();
  
  private final Pattern UCIDANDNAME_PATTERN = new Function0<Pattern>() {
    public Pattern apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(UcmLang2UcmService.this.UC_REGEXP, "");
      _builder.append("\\s+(.*)");
      Pattern _compile = Pattern.compile(_builder.toString());
      return _compile;
    }
  }.apply();
  
  private final Pattern BranchingLabeledAnnotatedText_PATTERN = new Function0<Pattern>() {
    public Pattern apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("(\\w+):\\s+(.*)");
      Pattern _compile = Pattern.compile(_builder.toString());
      return _compile;
    }
  }.apply();
  
  private final Pattern LabelAndRest_PATTERN = new Function0<Pattern>() {
    public Pattern apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("(\\d\\w*)[.]?\\s+(.*)");
      Pattern _compile = Pattern.compile(_builder.toString());
      return _compile;
    }
  }.apply();
  
  public UseCaseModel transform(final Collection<? extends CharSequence> texts) {
    UseCaseModel _createUseCaseModel = this.usecaseFactory.createUseCaseModel();
    final Procedure1<UseCaseModel> _function = new Procedure1<UseCaseModel>() {
      public void apply(final UseCaseModel it) {
        final HashMultimap<UseCase, String> precedingMap = HashMultimap.<UseCase, String>create();
        for (final CharSequence text : texts) {
          UcmLang2UcmService.this.parseUseCase(text, it, precedingMap);
        }
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("use-cases: ");
        EList<UseCase> _useCases = it.getUseCases();
        final Function1<UseCase, String> _function = new Function1<UseCase, String>() {
          public String apply(final UseCase it) {
            return it.getId();
          }
        };
        List<String> _map = ListExtensions.<UseCase, String>map(_useCases, _function);
        String _join = IterableExtensions.join(_map, ", ");
        _builder.append(_join, "");
        UcmLang2UcmService.this.info(_builder);
        UcmLang2UcmService.this.resolvePreceding(precedingMap, it);
      }
    };
    return ObjectExtensions.<UseCaseModel>operator_doubleArrow(_createUseCaseModel, _function);
  }
  
  private void resolvePreceding(final Multimap<UseCase, String> precedingMap, final UseCaseModel useCaseModel) {
    final EList<UseCase> allUseCases = useCaseModel.getUseCases();
    final HashMap<String, UseCase> id2UseCase = new HashMap<String, UseCase>();
    final Procedure1<UseCase> _function = new Procedure1<UseCase>() {
      public void apply(final UseCase it) {
        String _id = it.getId();
        id2UseCase.put(_id, it);
      }
    };
    IterableExtensions.<UseCase>forEach(allUseCases, _function);
    Collection<Map.Entry<UseCase, String>> _entries = precedingMap.entries();
    for (final Map.Entry<UseCase, String> entry : _entries) {
      {
        String _value = entry.getValue();
        final UseCase precedingUseCase = id2UseCase.get(_value);
        final UseCase useCase = entry.getKey();
        EList<UseCase> _preceeded = useCase.getPreceeded();
        _preceeded.add(precedingUseCase);
      }
    }
  }
  
  private void parseUseCase(final CharSequence text, final UseCaseModel useCaseModel, final Multimap<UseCase, String> precedingMap) {
    try {
      final UseCase useCase = this.usecaseFactory.createUseCase();
      EList<UseCase> _useCases = useCaseModel.getUseCases();
      _useCases.add(useCase);
      Splitter _on = Splitter.on("\n");
      final Splitter splitter = _on.trimResults();
      Iterable<String> _split = splitter.split(text);
      final LinkedList<String> lines = Lists.<String>newLinkedList(_split);
      final IdAndName idAndName = this.parseIdAndName(lines);
      String _id = idAndName.getId();
      useCase.setId(_id);
      String _name = idAndName.getName();
      useCase.setName(_name);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Found use-case \"");
      String _id_1 = useCase.getId();
      _builder.append(_id_1, "");
      _builder.append(": ");
      String _name_1 = useCase.getName();
      _builder.append(_name_1, "");
      _builder.append("\"");
      this.info(_builder);
      boolean _parseIsPrimary = this.parseIsPrimary(lines);
      useCase.setPrimary(_parseIsPrimary);
      ArrayList<String> _parsePreceding = this.parsePreceding(lines);
      precedingMap.putAll(useCase, _parsePreceding);
      Scenario _parseScenario = this.parseScenario(lines, "");
      useCase.setMainScenario(_parseScenario);
      final HashMap<String, Step> labelToStep = new HashMap<String, Step>();
      Scenario _mainScenario = useCase.getMainScenario();
      EList<Step> _steps = _mainScenario.getSteps();
      final Procedure1<Step> _function = new Procedure1<Step>() {
        public void apply(final Step it) {
          String _label = it.getLabel();
          labelToStep.put(_label, it);
        }
      };
      IterableExtensions.<Step>forEach(_steps, _function);
      boolean _isEmpty = lines.isEmpty();
      boolean _not = (!_isEmpty);
      boolean _while = _not;
      while (_while) {
        {
          final BranchingLabeledAnnotatedText branching = this.parseBranching(lines);
          LabeledAnnotatedText _labeledAnnotatedText = branching.getLabeledAnnotatedText();
          final String prefix = _labeledAnnotatedText.getLabel();
          boolean _matches = prefix.matches("(\\d+[a-z])+");
          boolean _not_1 = (!_matches);
          if (_not_1) {
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("Unable to parse branching prefix: ");
            _builder_1.append(prefix, "");
            throw new ParseException(_builder_1.toString(), (-1));
          }
          int _length = prefix.length();
          int _minus = (_length - 1);
          final String stepLabel = prefix.substring(0, _minus);
          boolean _containsKey = labelToStep.containsKey(stepLabel);
          boolean _not_2 = (!_containsKey);
          if (_not_2) {
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append("Cannot find step with label ");
            _builder_2.append(stepLabel, "");
            throw new ParseException(_builder_2.toString(), (-1));
          }
          final Step step = labelToStep.get(stepLabel);
          EMap<Step, ScenarioHolder> _branches = useCase.getBranches();
          Set<Step> _keySet = _branches.keySet();
          boolean _contains = _keySet.contains(step);
          boolean _not_3 = (!_contains);
          if (_not_3) {
            final ScenarioHolder holder = this.usecaseFactory.createScenarioHolder();
            EMap<Step, ScenarioHolder> _branches_1 = useCase.getBranches();
            _branches_1.put(step, holder);
          }
          EMap<Step, ScenarioHolder> _branches_2 = useCase.getBranches();
          final ScenarioHolder scenarioHolder = _branches_2.get(step);
          final Scenario scenario = this.parseScenario(lines, prefix);
          LabeledAnnotatedText _labeledAnnotatedText_1 = branching.getLabeledAnnotatedText();
          AnnotatedText _annotatedText = _labeledAnnotatedText_1.getAnnotatedText();
          String _text = _annotatedText.getText();
          scenario.setText(_text);
          BranchingType _branchingType = branching.getBranchingType();
          boolean _equals = Objects.equal(_branchingType, BranchingType.Extension);
          if (_equals) {
            EList<Scenario> _extensions = scenarioHolder.getExtensions();
            _extensions.add(scenario);
          } else {
            EList<Scenario> _variations = scenarioHolder.getVariations();
            _variations.add(scenario);
          }
          String _label = scenario.getLabel();
          boolean _notEquals = (!Objects.equal(prefix, _label));
          if (_notEquals) {
            StringConcatenation _builder_3 = new StringConcatenation();
            _builder_3.append("Expected prefix: ");
            _builder_3.append(prefix, "");
            _builder_3.append(" but was: ");
            String _label_1 = scenario.getLabel();
            _builder_3.append(_label_1, "");
            throw new ParseException(_builder_3.toString(), (-1));
          }
          EList<Step> _steps_1 = scenario.getSteps();
          final Procedure1<Step> _function_1 = new Procedure1<Step>() {
            public void apply(final Step it) {
              String _label = it.getLabel();
              labelToStep.put(_label, it);
            }
          };
          IterableExtensions.<Step>forEach(_steps_1, _function_1);
        }
        boolean _isEmpty_1 = lines.isEmpty();
        boolean _not_1 = (!_isEmpty_1);
        _while = _not_1;
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private IdAndName parseIdAndName(final LinkedList<String> lines) {
    try {
      this.popEmptyLines(lines);
      final String line = lines.pop();
      final Matcher matcher = this.UCIDANDNAME_PATTERN.matcher(line);
      boolean _matches = matcher.matches();
      boolean _not = (!_matches);
      if (_not) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Unable to parse use case name from line: ");
        _builder.append(line, "");
        throw new ParseException(_builder.toString(), (-1));
      }
      String _group = matcher.group(1);
      String _group_1 = matcher.group(2);
      return new IdAndName(_group, _group_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private boolean parseIsPrimary(final LinkedList<String> lines) {
    boolean _xblockexpression = false;
    {
      this.popEmptyLines(lines);
      final String line = lines.pop();
      final Pattern pattern = Pattern.compile(this.PRIMARY);
      final Matcher matcher = pattern.matcher(line);
      boolean _xifexpression = false;
      boolean _matches = matcher.matches();
      if (_matches) {
        String _group = matcher.group(1);
        _xifexpression = Boolean.parseBoolean(_group);
      } else {
        boolean _xblockexpression_1 = false;
        {
          lines.addFirst(line);
          _xblockexpression_1 = true;
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  private ArrayList<String> parsePreceding(final LinkedList<String> lines) {
    ArrayList<String> _xblockexpression = null;
    {
      this.popEmptyLines(lines);
      final String line = lines.pop();
      final ArrayList<String> list = new ArrayList<String>();
      boolean _startsWith = line.startsWith(this.PRECEDING);
      if (_startsWith) {
        final Pattern pattern = Pattern.compile(this.UC_REGEXP);
        final Matcher matcher = pattern.matcher(line);
        boolean _find = matcher.find();
        boolean _while = _find;
        while (_while) {
          String _group = matcher.group(1);
          list.add(_group);
          boolean _find_1 = matcher.find();
          _while = _find_1;
        }
      } else {
        lines.addFirst(line);
      }
      _xblockexpression = list;
    }
    return _xblockexpression;
  }
  
  private Scenario parseScenario(final LinkedList<String> lines, final String prefix) {
    try {
      Scenario _xblockexpression = null;
      {
        final Scenario scenario = this.usecaseFactory.createScenario();
        boolean _isEmpty = lines.isEmpty();
        boolean _not = (!_isEmpty);
        boolean _while = _not;
        while (_while) {
          {
            final LabeledAnnotatedText labelTextAnnotations = this.parseLabeledAnnotatedText(lines);
            boolean _equals = Objects.equal(labelTextAnnotations, null);
            if (_equals) {
              return scenario;
            }
            labelTextAnnotations.getLabel();
            EList<Step> _steps = scenario.getSteps();
            int _size = _steps.size();
            int _plus = (_size + 1);
            final String expectedLabel = (prefix + Integer.valueOf(_plus));
            String _label = labelTextAnnotations.getLabel();
            boolean _notEquals = (!Objects.equal(_label, expectedLabel));
            if (_notEquals) {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("Bad step label - expected ");
              _builder.append(expectedLabel, "");
              _builder.append(" at line \"");
              AnnotatedText _annotatedText = labelTextAnnotations.getAnnotatedText();
              String _text = _annotatedText.getText();
              _builder.append(_text, "");
              _builder.append("\"");
              throw new ParseException(_builder.toString(), (-1));
            }
            EList<Step> _steps_1 = scenario.getSteps();
            Step _createStep = this.usecaseFactory.createStep();
            final Procedure1<Step> _function = new Procedure1<Step>() {
              public void apply(final Step it) {
                AnnotatedText _annotatedText = labelTextAnnotations.getAnnotatedText();
                String _text = _annotatedText.getText();
                it.setText(_text);
                EList<Annotation> _annotations = it.getAnnotations();
                AnnotatedText _annotatedText_1 = labelTextAnnotations.getAnnotatedText();
                List<Annotation> _annotations_1 = _annotatedText_1.getAnnotations();
                _annotations.addAll(_annotations_1);
              }
            };
            Step _doubleArrow = ObjectExtensions.<Step>operator_doubleArrow(_createStep, _function);
            _steps_1.add(_doubleArrow);
          }
          boolean _isEmpty_1 = lines.isEmpty();
          boolean _not_1 = (!_isEmpty_1);
          _while = _not_1;
        }
        _xblockexpression = scenario;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private AnnotatedText separateTextAndAnnotations(final String textWithAnnotations) {
    AnnotatedText _xblockexpression = null;
    {
      final Pattern pattern = Pattern.compile(this.ANNOTATION_REGEXP);
      final Matcher matcher = pattern.matcher(textWithAnnotations);
      final boolean hasAnnotations = matcher.find();
      String _xifexpression = null;
      if (hasAnnotations) {
        int _start = matcher.start();
        String _substring = textWithAnnotations.substring(0, _start);
        _xifexpression = _substring.trim();
      } else {
        _xifexpression = textWithAnnotations;
      }
      final String text = _xifexpression;
      final List<Annotation> annotations = CollectionLiterals.<Annotation>newArrayList();
      if (hasAnnotations) {
        boolean _dowhile = false;
        do {
          {
            final String content = matcher.group(1);
            final String[] parts = content.split(":");
            UnknownAnnotation _createUnknownAnnotation = this.annotationFactory.createUnknownAnnotation();
            final Procedure1<UnknownAnnotation> _function = new Procedure1<UnknownAnnotation>() {
              public void apply(final UnknownAnnotation it) {
                EList<String> _parts = it.getParts();
                CollectionExtensions.<String>addAll(_parts, parts);
              }
            };
            final UnknownAnnotation ua = ObjectExtensions.<UnknownAnnotation>operator_doubleArrow(_createUnknownAnnotation, _function);
            annotations.add(ua);
          }
          boolean _find = matcher.find();
          _dowhile = _find;
        } while(_dowhile);
      }
      AnnotatedText _annotatedText = new AnnotatedText();
      final Procedure1<AnnotatedText> _function = new Procedure1<AnnotatedText>() {
        public void apply(final AnnotatedText it) {
          it.setAnnotations(annotations);
          it.setText(text);
        }
      };
      _xblockexpression = ObjectExtensions.<AnnotatedText>operator_doubleArrow(_annotatedText, _function);
    }
    return _xblockexpression;
  }
  
  private LabeledAnnotatedText parseLabeledAnnotatedText(final LinkedList<String> lines) {
    try {
      LabeledAnnotatedText _xblockexpression = null;
      {
        final String extensionStart = (BranchingType.Extension + ":");
        final String variationStart = (BranchingType.Variation + ":");
        boolean firstLineMatched = false;
        LabeledAnnotatedText result = new LabeledAnnotatedText();
        boolean _isEmpty = lines.isEmpty();
        boolean _not = (!_isEmpty);
        boolean _while = _not;
        while (_while) {
          {
            this.popEmptyLines(lines);
            boolean _isEmpty_1 = lines.isEmpty();
            if (_isEmpty_1) {
              return result;
            }
            final String line = lines.pop();
            final Matcher matcher = this.LabelAndRest_PATTERN.matcher(line);
            if ((!firstLineMatched)) {
              boolean _or = false;
              boolean _startsWith = line.startsWith(extensionStart);
              if (_startsWith) {
                _or = true;
              } else {
                boolean _startsWith_1 = line.startsWith(variationStart);
                _or = _startsWith_1;
              }
              if (_or) {
                lines.addFirst(line);
                return null;
              }
              boolean _matches = matcher.matches();
              boolean _not_1 = (!_matches);
              if (_not_1) {
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("Line with invalid format: ");
                _builder.append(line, "");
                throw new ParseException(_builder.toString(), (-1));
              }
              firstLineMatched = true;
              String _group = matcher.group(1);
              result.setLabel(_group);
              final String textWithAnnotations = matcher.group(2);
              AnnotatedText _separateTextAndAnnotations = this.separateTextAndAnnotations(textWithAnnotations);
              result.setAnnotatedText(_separateTextAndAnnotations);
            } else {
              boolean _or_1 = false;
              boolean _or_2 = false;
              boolean _matches_1 = matcher.matches();
              if (_matches_1) {
                _or_2 = true;
              } else {
                boolean _startsWith_2 = line.startsWith(extensionStart);
                _or_2 = _startsWith_2;
              }
              if (_or_2) {
                _or_1 = true;
              } else {
                boolean _startsWith_3 = line.startsWith(variationStart);
                _or_1 = _startsWith_3;
              }
              if (_or_1) {
                lines.addFirst(line);
                return result;
              }
              final AnnotatedText additionalTextWithAnnotations = this.separateTextAndAnnotations(line);
              AnnotatedText _annotatedText = result.getAnnotatedText();
              StringConcatenation _builder_1 = new StringConcatenation();
              AnnotatedText _annotatedText_1 = result.getAnnotatedText();
              String _text = _annotatedText_1.getText();
              _builder_1.append(_text, "");
              _builder_1.append(" ");
              String _text_1 = additionalTextWithAnnotations.getText();
              _builder_1.append(_text_1, "");
              _annotatedText.setText(_builder_1.toString());
              AnnotatedText _annotatedText_2 = result.getAnnotatedText();
              List<Annotation> _annotations = _annotatedText_2.getAnnotations();
              List<Annotation> _annotations_1 = additionalTextWithAnnotations.getAnnotations();
              Iterables.<Annotation>addAll(_annotations, _annotations_1);
            }
          }
          boolean _isEmpty_1 = lines.isEmpty();
          boolean _not_1 = (!_isEmpty_1);
          _while = _not_1;
        }
        _xblockexpression = result;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private BranchingLabeledAnnotatedText parseBranching(final LinkedList<String> lines) {
    try {
      BranchingLabeledAnnotatedText _xblockexpression = null;
      {
        this.popEmptyLines(lines);
        final String line = lines.pop();
        final Matcher matcher = this.BranchingLabeledAnnotatedText_PATTERN.matcher(line);
        boolean _matches = matcher.matches();
        boolean _not = (!_matches);
        if (_not) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Branching has invalid format: ");
          _builder.append(line, "");
          throw new ParseException(_builder.toString(), (-1));
        }
        String _group = matcher.group(1);
        final BranchingType branchingType = BranchingType.valueOf(_group);
        String _group_1 = matcher.group(2);
        lines.addFirst(_group_1);
        final LabeledAnnotatedText brachingTextAndAnnotations = this.parseLabeledAnnotatedText(lines);
        _xblockexpression = new BranchingLabeledAnnotatedText(branchingType, brachingTextAndAnnotations);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void popEmptyLines(final LinkedList<String> lines) {
    boolean _isEmpty = lines.isEmpty();
    boolean _not = (!_isEmpty);
    boolean _while = _not;
    while (_while) {
      {
        final String line = lines.pop();
        boolean _isEmpty_1 = line.isEmpty();
        boolean _not_1 = (!_isEmpty_1);
        if (_not_1) {
          lines.addFirst(line);
          return;
        }
      }
      boolean _isEmpty_1 = lines.isEmpty();
      boolean _not_1 = (!_isEmpty_1);
      _while = _not_1;
    }
  }
}
