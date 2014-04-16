package transformation.ctllang2ctl.parser.antlr.internal; 

import org.antlr.runtime.BitSet;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;

import transformation.ctllang2ctl.services.CtlXtextGrammarAccess;

@SuppressWarnings("all")
public class InternalCtlXtextParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'AG'", "'AF'", "'AX'", "'EG'", "'EF'", "'EX'", "'A'", "'E'", "'['", "'U'", "']'", "'->'", "'<->'", "'|'", "'&'", "'!'", "'('", "')'", "'true'", "'false'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalCtlXtextParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCtlXtextParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCtlXtextParser.tokenNames; }
    public String getGrammarFileName() { return "../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g"; }



     	private CtlXtextGrammarAccess grammarAccess;
     	
        public InternalCtlXtextParser(TokenStream input, CtlXtextGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "RuleStart";	
       	}
       	
       	@Override
       	protected CtlXtextGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleRuleStart"
    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:67:1: entryRuleRuleStart returns [EObject current=null] : iv_ruleRuleStart= ruleRuleStart EOF ;
    public final EObject entryRuleRuleStart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleStart = null;


        try {
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:68:2: (iv_ruleRuleStart= ruleRuleStart EOF )
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:69:2: iv_ruleRuleStart= ruleRuleStart EOF
            {
             newCompositeNode(grammarAccess.getRuleStartRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleStart_in_entryRuleRuleStart75);
            iv_ruleRuleStart=ruleRuleStart();

            state._fsp--;

             current =iv_ruleRuleStart; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleStart85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleStart"


    // $ANTLR start "ruleRuleStart"
    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:76:1: ruleRuleStart returns [EObject current=null] : this_RuleArrow_0= ruleRuleArrow ;
    public final EObject ruleRuleStart() throws RecognitionException {
        EObject current = null;

        EObject this_RuleArrow_0 = null;


         enterRule(); 
            
        try {
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:79:28: (this_RuleArrow_0= ruleRuleArrow )
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:81:5: this_RuleArrow_0= ruleRuleArrow
            {
             
                    newCompositeNode(grammarAccess.getRuleStartAccess().getRuleArrowParserRuleCall()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleRuleArrow_in_ruleRuleStart131);
            this_RuleArrow_0=ruleRuleArrow();

            state._fsp--;

             
                    current = this_RuleArrow_0; 
                    afterParserOrEnumRuleCall();
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleStart"


    // $ANTLR start "entryRuleRuleSimple"
    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:97:1: entryRuleRuleSimple returns [EObject current=null] : iv_ruleRuleSimple= ruleRuleSimple EOF ;
    public final EObject entryRuleRuleSimple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleSimple = null;


        try {
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:98:2: (iv_ruleRuleSimple= ruleRuleSimple EOF )
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:99:2: iv_ruleRuleSimple= ruleRuleSimple EOF
            {
             newCompositeNode(grammarAccess.getRuleSimpleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleSimple_in_entryRuleRuleSimple165);
            iv_ruleRuleSimple=ruleRuleSimple();

            state._fsp--;

             current =iv_ruleRuleSimple; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleSimple175); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleSimple"


    // $ANTLR start "ruleRuleSimple"
    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:106:1: ruleRuleSimple returns [EObject current=null] : ( ( ( ( () otherlv_1= 'AG' ) | ( () otherlv_3= 'AF' ) | ( () otherlv_5= 'AX' ) | ( () otherlv_7= 'EG' ) | ( () otherlv_9= 'EF' ) | ( () otherlv_11= 'EX' ) ) ( (lv_formula_12_0= ruleRuleStart ) ) ) | ( ( ( () otherlv_14= 'A' ) | ( () otherlv_16= 'E' ) ) otherlv_17= '[' ( (lv_left_18_0= ruleRuleStart ) ) otherlv_19= 'U' ( (lv_right_20_0= ruleRuleStart ) ) otherlv_21= ']' ) | this_RuleUnaryPropositionalLogic_22= ruleRuleUnaryPropositionalLogic ) ;
    public final EObject ruleRuleSimple() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        EObject lv_formula_12_0 = null;

        EObject lv_left_18_0 = null;

        EObject lv_right_20_0 = null;

        EObject this_RuleUnaryPropositionalLogic_22 = null;


         enterRule(); 
            
        try {
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:109:28: ( ( ( ( ( () otherlv_1= 'AG' ) | ( () otherlv_3= 'AF' ) | ( () otherlv_5= 'AX' ) | ( () otherlv_7= 'EG' ) | ( () otherlv_9= 'EF' ) | ( () otherlv_11= 'EX' ) ) ( (lv_formula_12_0= ruleRuleStart ) ) ) | ( ( ( () otherlv_14= 'A' ) | ( () otherlv_16= 'E' ) ) otherlv_17= '[' ( (lv_left_18_0= ruleRuleStart ) ) otherlv_19= 'U' ( (lv_right_20_0= ruleRuleStart ) ) otherlv_21= ']' ) | this_RuleUnaryPropositionalLogic_22= ruleRuleUnaryPropositionalLogic ) )
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:110:1: ( ( ( ( () otherlv_1= 'AG' ) | ( () otherlv_3= 'AF' ) | ( () otherlv_5= 'AX' ) | ( () otherlv_7= 'EG' ) | ( () otherlv_9= 'EF' ) | ( () otherlv_11= 'EX' ) ) ( (lv_formula_12_0= ruleRuleStart ) ) ) | ( ( ( () otherlv_14= 'A' ) | ( () otherlv_16= 'E' ) ) otherlv_17= '[' ( (lv_left_18_0= ruleRuleStart ) ) otherlv_19= 'U' ( (lv_right_20_0= ruleRuleStart ) ) otherlv_21= ']' ) | this_RuleUnaryPropositionalLogic_22= ruleRuleUnaryPropositionalLogic )
            {
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:110:1: ( ( ( ( () otherlv_1= 'AG' ) | ( () otherlv_3= 'AF' ) | ( () otherlv_5= 'AX' ) | ( () otherlv_7= 'EG' ) | ( () otherlv_9= 'EF' ) | ( () otherlv_11= 'EX' ) ) ( (lv_formula_12_0= ruleRuleStart ) ) ) | ( ( ( () otherlv_14= 'A' ) | ( () otherlv_16= 'E' ) ) otherlv_17= '[' ( (lv_left_18_0= ruleRuleStart ) ) otherlv_19= 'U' ( (lv_right_20_0= ruleRuleStart ) ) otherlv_21= ']' ) | this_RuleUnaryPropositionalLogic_22= ruleRuleUnaryPropositionalLogic )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                {
                alt3=1;
                }
                break;
            case 17:
            case 18:
                {
                alt3=2;
                }
                break;
            case RULE_ID:
            case 26:
            case 27:
            case 29:
            case 30:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:110:2: ( ( ( () otherlv_1= 'AG' ) | ( () otherlv_3= 'AF' ) | ( () otherlv_5= 'AX' ) | ( () otherlv_7= 'EG' ) | ( () otherlv_9= 'EF' ) | ( () otherlv_11= 'EX' ) ) ( (lv_formula_12_0= ruleRuleStart ) ) )
                    {
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:110:2: ( ( ( () otherlv_1= 'AG' ) | ( () otherlv_3= 'AF' ) | ( () otherlv_5= 'AX' ) | ( () otherlv_7= 'EG' ) | ( () otherlv_9= 'EF' ) | ( () otherlv_11= 'EX' ) ) ( (lv_formula_12_0= ruleRuleStart ) ) )
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:110:3: ( ( () otherlv_1= 'AG' ) | ( () otherlv_3= 'AF' ) | ( () otherlv_5= 'AX' ) | ( () otherlv_7= 'EG' ) | ( () otherlv_9= 'EF' ) | ( () otherlv_11= 'EX' ) ) ( (lv_formula_12_0= ruleRuleStart ) )
                    {
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:110:3: ( ( () otherlv_1= 'AG' ) | ( () otherlv_3= 'AF' ) | ( () otherlv_5= 'AX' ) | ( () otherlv_7= 'EG' ) | ( () otherlv_9= 'EF' ) | ( () otherlv_11= 'EX' ) )
                    int alt1=6;
                    switch ( input.LA(1) ) {
                    case 11:
                        {
                        alt1=1;
                        }
                        break;
                    case 12:
                        {
                        alt1=2;
                        }
                        break;
                    case 13:
                        {
                        alt1=3;
                        }
                        break;
                    case 14:
                        {
                        alt1=4;
                        }
                        break;
                    case 15:
                        {
                        alt1=5;
                        }
                        break;
                    case 16:
                        {
                        alt1=6;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 0, input);

                        throw nvae;
                    }

                    switch (alt1) {
                        case 1 :
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:110:4: ( () otherlv_1= 'AG' )
                            {
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:110:4: ( () otherlv_1= 'AG' )
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:110:5: () otherlv_1= 'AG'
                            {
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:110:5: ()
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:111:5: 
                            {

                                    current = forceCreateModelElement(
                                        grammarAccess.getRuleSimpleAccess().getAllGloballyAction_0_0_0_0(),
                                        current);
                                

                            }

                            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleRuleSimple224); 

                                	newLeafNode(otherlv_1, grammarAccess.getRuleSimpleAccess().getAGKeyword_0_0_0_1());
                                

                            }


                            }
                            break;
                        case 2 :
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:121:6: ( () otherlv_3= 'AF' )
                            {
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:121:6: ( () otherlv_3= 'AF' )
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:121:7: () otherlv_3= 'AF'
                            {
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:121:7: ()
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:122:5: 
                            {

                                    current = forceCreateModelElement(
                                        grammarAccess.getRuleSimpleAccess().getAllFinallyAction_0_0_1_0(),
                                        current);
                                

                            }

                            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleRuleSimple253); 

                                	newLeafNode(otherlv_3, grammarAccess.getRuleSimpleAccess().getAFKeyword_0_0_1_1());
                                

                            }


                            }
                            break;
                        case 3 :
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:132:6: ( () otherlv_5= 'AX' )
                            {
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:132:6: ( () otherlv_5= 'AX' )
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:132:7: () otherlv_5= 'AX'
                            {
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:132:7: ()
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:133:5: 
                            {

                                    current = forceCreateModelElement(
                                        grammarAccess.getRuleSimpleAccess().getAllNextAction_0_0_2_0(),
                                        current);
                                

                            }

                            otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleRuleSimple282); 

                                	newLeafNode(otherlv_5, grammarAccess.getRuleSimpleAccess().getAXKeyword_0_0_2_1());
                                

                            }


                            }
                            break;
                        case 4 :
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:143:6: ( () otherlv_7= 'EG' )
                            {
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:143:6: ( () otherlv_7= 'EG' )
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:143:7: () otherlv_7= 'EG'
                            {
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:143:7: ()
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:144:5: 
                            {

                                    current = forceCreateModelElement(
                                        grammarAccess.getRuleSimpleAccess().getExistsGloballyAction_0_0_3_0(),
                                        current);
                                

                            }

                            otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleRuleSimple311); 

                                	newLeafNode(otherlv_7, grammarAccess.getRuleSimpleAccess().getEGKeyword_0_0_3_1());
                                

                            }


                            }
                            break;
                        case 5 :
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:154:6: ( () otherlv_9= 'EF' )
                            {
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:154:6: ( () otherlv_9= 'EF' )
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:154:7: () otherlv_9= 'EF'
                            {
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:154:7: ()
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:155:5: 
                            {

                                    current = forceCreateModelElement(
                                        grammarAccess.getRuleSimpleAccess().getExistsFinallyAction_0_0_4_0(),
                                        current);
                                

                            }

                            otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleRuleSimple340); 

                                	newLeafNode(otherlv_9, grammarAccess.getRuleSimpleAccess().getEFKeyword_0_0_4_1());
                                

                            }


                            }
                            break;
                        case 6 :
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:165:6: ( () otherlv_11= 'EX' )
                            {
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:165:6: ( () otherlv_11= 'EX' )
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:165:7: () otherlv_11= 'EX'
                            {
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:165:7: ()
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:166:5: 
                            {

                                    current = forceCreateModelElement(
                                        grammarAccess.getRuleSimpleAccess().getExistsNextAction_0_0_5_0(),
                                        current);
                                

                            }

                            otherlv_11=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleRuleSimple369); 

                                	newLeafNode(otherlv_11, grammarAccess.getRuleSimpleAccess().getEXKeyword_0_0_5_1());
                                

                            }


                            }
                            break;

                    }

                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:175:3: ( (lv_formula_12_0= ruleRuleStart ) )
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:176:1: (lv_formula_12_0= ruleRuleStart )
                    {
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:176:1: (lv_formula_12_0= ruleRuleStart )
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:177:3: lv_formula_12_0= ruleRuleStart
                    {
                     
                    	        newCompositeNode(grammarAccess.getRuleSimpleAccess().getFormulaRuleStartParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleRuleStart_in_ruleRuleSimple392);
                    lv_formula_12_0=ruleRuleStart();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRuleSimpleRule());
                    	        }
                           		set(
                           			current, 
                           			"formula",
                            		lv_formula_12_0, 
                            		"RuleStart");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:194:6: ( ( ( () otherlv_14= 'A' ) | ( () otherlv_16= 'E' ) ) otherlv_17= '[' ( (lv_left_18_0= ruleRuleStart ) ) otherlv_19= 'U' ( (lv_right_20_0= ruleRuleStart ) ) otherlv_21= ']' )
                    {
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:194:6: ( ( ( () otherlv_14= 'A' ) | ( () otherlv_16= 'E' ) ) otherlv_17= '[' ( (lv_left_18_0= ruleRuleStart ) ) otherlv_19= 'U' ( (lv_right_20_0= ruleRuleStart ) ) otherlv_21= ']' )
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:194:7: ( ( () otherlv_14= 'A' ) | ( () otherlv_16= 'E' ) ) otherlv_17= '[' ( (lv_left_18_0= ruleRuleStart ) ) otherlv_19= 'U' ( (lv_right_20_0= ruleRuleStart ) ) otherlv_21= ']'
                    {
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:194:7: ( ( () otherlv_14= 'A' ) | ( () otherlv_16= 'E' ) )
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==17) ) {
                        alt2=1;
                    }
                    else if ( (LA2_0==18) ) {
                        alt2=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 0, input);

                        throw nvae;
                    }
                    switch (alt2) {
                        case 1 :
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:194:8: ( () otherlv_14= 'A' )
                            {
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:194:8: ( () otherlv_14= 'A' )
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:194:9: () otherlv_14= 'A'
                            {
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:194:9: ()
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:195:5: 
                            {

                                    current = forceCreateModelElement(
                                        grammarAccess.getRuleSimpleAccess().getAllUntilAction_1_0_0_0(),
                                        current);
                                

                            }

                            otherlv_14=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleRuleSimple423); 

                                	newLeafNode(otherlv_14, grammarAccess.getRuleSimpleAccess().getAKeyword_1_0_0_1());
                                

                            }


                            }
                            break;
                        case 2 :
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:205:6: ( () otherlv_16= 'E' )
                            {
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:205:6: ( () otherlv_16= 'E' )
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:205:7: () otherlv_16= 'E'
                            {
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:205:7: ()
                            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:206:5: 
                            {

                                    current = forceCreateModelElement(
                                        grammarAccess.getRuleSimpleAccess().getExistsUntilAction_1_0_1_0(),
                                        current);
                                

                            }

                            otherlv_16=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleRuleSimple452); 

                                	newLeafNode(otherlv_16, grammarAccess.getRuleSimpleAccess().getEKeyword_1_0_1_1());
                                

                            }


                            }
                            break;

                    }

                    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleRuleSimple466); 

                        	newLeafNode(otherlv_17, grammarAccess.getRuleSimpleAccess().getLeftSquareBracketKeyword_1_1());
                        
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:219:1: ( (lv_left_18_0= ruleRuleStart ) )
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:220:1: (lv_left_18_0= ruleRuleStart )
                    {
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:220:1: (lv_left_18_0= ruleRuleStart )
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:221:3: lv_left_18_0= ruleRuleStart
                    {
                     
                    	        newCompositeNode(grammarAccess.getRuleSimpleAccess().getLeftRuleStartParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleRuleStart_in_ruleRuleSimple487);
                    lv_left_18_0=ruleRuleStart();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRuleSimpleRule());
                    	        }
                           		set(
                           			current, 
                           			"left",
                            		lv_left_18_0, 
                            		"RuleStart");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_19=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleRuleSimple499); 

                        	newLeafNode(otherlv_19, grammarAccess.getRuleSimpleAccess().getUKeyword_1_3());
                        
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:241:1: ( (lv_right_20_0= ruleRuleStart ) )
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:242:1: (lv_right_20_0= ruleRuleStart )
                    {
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:242:1: (lv_right_20_0= ruleRuleStart )
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:243:3: lv_right_20_0= ruleRuleStart
                    {
                     
                    	        newCompositeNode(grammarAccess.getRuleSimpleAccess().getRightRuleStartParserRuleCall_1_4_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleRuleStart_in_ruleRuleSimple520);
                    lv_right_20_0=ruleRuleStart();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRuleSimpleRule());
                    	        }
                           		set(
                           			current, 
                           			"right",
                            		lv_right_20_0, 
                            		"RuleStart");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_21=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleRuleSimple532); 

                        	newLeafNode(otherlv_21, grammarAccess.getRuleSimpleAccess().getRightSquareBracketKeyword_1_5());
                        

                    }


                    }
                    break;
                case 3 :
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:265:5: this_RuleUnaryPropositionalLogic_22= ruleRuleUnaryPropositionalLogic
                    {
                     
                            newCompositeNode(grammarAccess.getRuleSimpleAccess().getRuleUnaryPropositionalLogicParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRuleUnaryPropositionalLogic_in_ruleRuleSimple561);
                    this_RuleUnaryPropositionalLogic_22=ruleRuleUnaryPropositionalLogic();

                    state._fsp--;

                     
                            current = this_RuleUnaryPropositionalLogic_22; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleSimple"


    // $ANTLR start "entryRuleRuleArrow"
    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:281:1: entryRuleRuleArrow returns [EObject current=null] : iv_ruleRuleArrow= ruleRuleArrow EOF ;
    public final EObject entryRuleRuleArrow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleArrow = null;


        try {
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:282:2: (iv_ruleRuleArrow= ruleRuleArrow EOF )
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:283:2: iv_ruleRuleArrow= ruleRuleArrow EOF
            {
             newCompositeNode(grammarAccess.getRuleArrowRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleArrow_in_entryRuleRuleArrow596);
            iv_ruleRuleArrow=ruleRuleArrow();

            state._fsp--;

             current =iv_ruleRuleArrow; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleArrow606); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleArrow"


    // $ANTLR start "ruleRuleArrow"
    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:290:1: ruleRuleArrow returns [EObject current=null] : (this_RuleDisjunction_0= ruleRuleDisjunction ( ( ( () otherlv_2= '->' ) | ( () otherlv_4= '<->' ) ) ( (lv_right_5_0= ruleRuleDisjunction ) ) )* ) ;
    public final EObject ruleRuleArrow() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_RuleDisjunction_0 = null;

        EObject lv_right_5_0 = null;


         enterRule(); 
            
        try {
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:293:28: ( (this_RuleDisjunction_0= ruleRuleDisjunction ( ( ( () otherlv_2= '->' ) | ( () otherlv_4= '<->' ) ) ( (lv_right_5_0= ruleRuleDisjunction ) ) )* ) )
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:294:1: (this_RuleDisjunction_0= ruleRuleDisjunction ( ( ( () otherlv_2= '->' ) | ( () otherlv_4= '<->' ) ) ( (lv_right_5_0= ruleRuleDisjunction ) ) )* )
            {
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:294:1: (this_RuleDisjunction_0= ruleRuleDisjunction ( ( ( () otherlv_2= '->' ) | ( () otherlv_4= '<->' ) ) ( (lv_right_5_0= ruleRuleDisjunction ) ) )* )
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:295:5: this_RuleDisjunction_0= ruleRuleDisjunction ( ( ( () otherlv_2= '->' ) | ( () otherlv_4= '<->' ) ) ( (lv_right_5_0= ruleRuleDisjunction ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getRuleArrowAccess().getRuleDisjunctionParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleRuleDisjunction_in_ruleRuleArrow653);
            this_RuleDisjunction_0=ruleRuleDisjunction();

            state._fsp--;

             
                    current = this_RuleDisjunction_0; 
                    afterParserOrEnumRuleCall();
                
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:303:1: ( ( ( () otherlv_2= '->' ) | ( () otherlv_4= '<->' ) ) ( (lv_right_5_0= ruleRuleDisjunction ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==22) ) {
                    alt5=1;
                }
                else if ( (LA5_0==23) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:303:2: ( ( () otherlv_2= '->' ) | ( () otherlv_4= '<->' ) ) ( (lv_right_5_0= ruleRuleDisjunction ) )
            	    {
            	    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:303:2: ( ( () otherlv_2= '->' ) | ( () otherlv_4= '<->' ) )
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0==22) ) {
            	        alt4=1;
            	    }
            	    else if ( (LA4_0==23) ) {
            	        alt4=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 4, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:303:3: ( () otherlv_2= '->' )
            	            {
            	            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:303:3: ( () otherlv_2= '->' )
            	            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:303:4: () otherlv_2= '->'
            	            {
            	            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:303:4: ()
            	            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:304:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getRuleArrowAccess().getImplicationLeftAction_1_0_0_0(),
            	                        current);
            	                

            	            }

            	            otherlv_2=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleRuleArrow676); 

            	                	newLeafNode(otherlv_2, grammarAccess.getRuleArrowAccess().getHyphenMinusGreaterThanSignKeyword_1_0_0_1());
            	                

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:314:6: ( () otherlv_4= '<->' )
            	            {
            	            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:314:6: ( () otherlv_4= '<->' )
            	            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:314:7: () otherlv_4= '<->'
            	            {
            	            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:314:7: ()
            	            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:315:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getRuleArrowAccess().getEquivalenceLeftAction_1_0_1_0(),
            	                        current);
            	                

            	            }

            	            otherlv_4=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleRuleArrow705); 

            	                	newLeafNode(otherlv_4, grammarAccess.getRuleArrowAccess().getLessThanSignHyphenMinusGreaterThanSignKeyword_1_0_1_1());
            	                

            	            }


            	            }
            	            break;

            	    }

            	    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:324:3: ( (lv_right_5_0= ruleRuleDisjunction ) )
            	    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:325:1: (lv_right_5_0= ruleRuleDisjunction )
            	    {
            	    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:325:1: (lv_right_5_0= ruleRuleDisjunction )
            	    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:326:3: lv_right_5_0= ruleRuleDisjunction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRuleArrowAccess().getRightRuleDisjunctionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleRuleDisjunction_in_ruleRuleArrow728);
            	    lv_right_5_0=ruleRuleDisjunction();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRuleArrowRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_5_0, 
            	            		"RuleDisjunction");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleArrow"


    // $ANTLR start "entryRuleRuleDisjunction"
    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:350:1: entryRuleRuleDisjunction returns [EObject current=null] : iv_ruleRuleDisjunction= ruleRuleDisjunction EOF ;
    public final EObject entryRuleRuleDisjunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleDisjunction = null;


        try {
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:351:2: (iv_ruleRuleDisjunction= ruleRuleDisjunction EOF )
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:352:2: iv_ruleRuleDisjunction= ruleRuleDisjunction EOF
            {
             newCompositeNode(grammarAccess.getRuleDisjunctionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleDisjunction_in_entryRuleRuleDisjunction766);
            iv_ruleRuleDisjunction=ruleRuleDisjunction();

            state._fsp--;

             current =iv_ruleRuleDisjunction; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleDisjunction776); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleDisjunction"


    // $ANTLR start "ruleRuleDisjunction"
    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:359:1: ruleRuleDisjunction returns [EObject current=null] : (this_RuleConjunction_0= ruleRuleConjunction ( () otherlv_2= '|' ( (lv_right_3_0= ruleRuleConjunction ) ) )* ) ;
    public final EObject ruleRuleDisjunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_RuleConjunction_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:362:28: ( (this_RuleConjunction_0= ruleRuleConjunction ( () otherlv_2= '|' ( (lv_right_3_0= ruleRuleConjunction ) ) )* ) )
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:363:1: (this_RuleConjunction_0= ruleRuleConjunction ( () otherlv_2= '|' ( (lv_right_3_0= ruleRuleConjunction ) ) )* )
            {
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:363:1: (this_RuleConjunction_0= ruleRuleConjunction ( () otherlv_2= '|' ( (lv_right_3_0= ruleRuleConjunction ) ) )* )
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:364:5: this_RuleConjunction_0= ruleRuleConjunction ( () otherlv_2= '|' ( (lv_right_3_0= ruleRuleConjunction ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getRuleDisjunctionAccess().getRuleConjunctionParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleRuleConjunction_in_ruleRuleDisjunction823);
            this_RuleConjunction_0=ruleRuleConjunction();

            state._fsp--;

             
                    current = this_RuleConjunction_0; 
                    afterParserOrEnumRuleCall();
                
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:372:1: ( () otherlv_2= '|' ( (lv_right_3_0= ruleRuleConjunction ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==24) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:372:2: () otherlv_2= '|' ( (lv_right_3_0= ruleRuleConjunction ) )
            	    {
            	    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:372:2: ()
            	    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:373:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getRuleDisjunctionAccess().getOrLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleRuleDisjunction844); 

            	        	newLeafNode(otherlv_2, grammarAccess.getRuleDisjunctionAccess().getVerticalLineKeyword_1_1());
            	        
            	    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:382:1: ( (lv_right_3_0= ruleRuleConjunction ) )
            	    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:383:1: (lv_right_3_0= ruleRuleConjunction )
            	    {
            	    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:383:1: (lv_right_3_0= ruleRuleConjunction )
            	    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:384:3: lv_right_3_0= ruleRuleConjunction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRuleDisjunctionAccess().getRightRuleConjunctionParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleRuleConjunction_in_ruleRuleDisjunction865);
            	    lv_right_3_0=ruleRuleConjunction();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRuleDisjunctionRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"RuleConjunction");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleDisjunction"


    // $ANTLR start "entryRuleRuleConjunction"
    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:408:1: entryRuleRuleConjunction returns [EObject current=null] : iv_ruleRuleConjunction= ruleRuleConjunction EOF ;
    public final EObject entryRuleRuleConjunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleConjunction = null;


        try {
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:409:2: (iv_ruleRuleConjunction= ruleRuleConjunction EOF )
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:410:2: iv_ruleRuleConjunction= ruleRuleConjunction EOF
            {
             newCompositeNode(grammarAccess.getRuleConjunctionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleConjunction_in_entryRuleRuleConjunction903);
            iv_ruleRuleConjunction=ruleRuleConjunction();

            state._fsp--;

             current =iv_ruleRuleConjunction; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleConjunction913); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleConjunction"


    // $ANTLR start "ruleRuleConjunction"
    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:417:1: ruleRuleConjunction returns [EObject current=null] : (this_RuleSimple_0= ruleRuleSimple ( () otherlv_2= '&' ( (lv_right_3_0= ruleRuleSimple ) ) )* ) ;
    public final EObject ruleRuleConjunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_RuleSimple_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:420:28: ( (this_RuleSimple_0= ruleRuleSimple ( () otherlv_2= '&' ( (lv_right_3_0= ruleRuleSimple ) ) )* ) )
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:421:1: (this_RuleSimple_0= ruleRuleSimple ( () otherlv_2= '&' ( (lv_right_3_0= ruleRuleSimple ) ) )* )
            {
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:421:1: (this_RuleSimple_0= ruleRuleSimple ( () otherlv_2= '&' ( (lv_right_3_0= ruleRuleSimple ) ) )* )
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:422:5: this_RuleSimple_0= ruleRuleSimple ( () otherlv_2= '&' ( (lv_right_3_0= ruleRuleSimple ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getRuleConjunctionAccess().getRuleSimpleParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleRuleSimple_in_ruleRuleConjunction960);
            this_RuleSimple_0=ruleRuleSimple();

            state._fsp--;

             
                    current = this_RuleSimple_0; 
                    afterParserOrEnumRuleCall();
                
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:430:1: ( () otherlv_2= '&' ( (lv_right_3_0= ruleRuleSimple ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==25) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:430:2: () otherlv_2= '&' ( (lv_right_3_0= ruleRuleSimple ) )
            	    {
            	    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:430:2: ()
            	    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:431:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getRuleConjunctionAccess().getAndLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleRuleConjunction981); 

            	        	newLeafNode(otherlv_2, grammarAccess.getRuleConjunctionAccess().getAmpersandKeyword_1_1());
            	        
            	    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:440:1: ( (lv_right_3_0= ruleRuleSimple ) )
            	    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:441:1: (lv_right_3_0= ruleRuleSimple )
            	    {
            	    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:441:1: (lv_right_3_0= ruleRuleSimple )
            	    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:442:3: lv_right_3_0= ruleRuleSimple
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRuleConjunctionAccess().getRightRuleSimpleParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleRuleSimple_in_ruleRuleConjunction1002);
            	    lv_right_3_0=ruleRuleSimple();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRuleConjunctionRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"RuleSimple");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleConjunction"


    // $ANTLR start "entryRuleRuleUnaryPropositionalLogic"
    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:466:1: entryRuleRuleUnaryPropositionalLogic returns [EObject current=null] : iv_ruleRuleUnaryPropositionalLogic= ruleRuleUnaryPropositionalLogic EOF ;
    public final EObject entryRuleRuleUnaryPropositionalLogic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleUnaryPropositionalLogic = null;


        try {
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:467:2: (iv_ruleRuleUnaryPropositionalLogic= ruleRuleUnaryPropositionalLogic EOF )
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:468:2: iv_ruleRuleUnaryPropositionalLogic= ruleRuleUnaryPropositionalLogic EOF
            {
             newCompositeNode(grammarAccess.getRuleUnaryPropositionalLogicRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleUnaryPropositionalLogic_in_entryRuleRuleUnaryPropositionalLogic1040);
            iv_ruleRuleUnaryPropositionalLogic=ruleRuleUnaryPropositionalLogic();

            state._fsp--;

             current =iv_ruleRuleUnaryPropositionalLogic; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleUnaryPropositionalLogic1050); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleUnaryPropositionalLogic"


    // $ANTLR start "ruleRuleUnaryPropositionalLogic"
    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:475:1: ruleRuleUnaryPropositionalLogic returns [EObject current=null] : ( ( () otherlv_1= '!' ( (lv_formula_2_0= ruleRuleStart ) ) ) | this_RuleAtomic_3= ruleRuleAtomic ) ;
    public final EObject ruleRuleUnaryPropositionalLogic() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_formula_2_0 = null;

        EObject this_RuleAtomic_3 = null;


         enterRule(); 
            
        try {
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:478:28: ( ( ( () otherlv_1= '!' ( (lv_formula_2_0= ruleRuleStart ) ) ) | this_RuleAtomic_3= ruleRuleAtomic ) )
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:479:1: ( ( () otherlv_1= '!' ( (lv_formula_2_0= ruleRuleStart ) ) ) | this_RuleAtomic_3= ruleRuleAtomic )
            {
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:479:1: ( ( () otherlv_1= '!' ( (lv_formula_2_0= ruleRuleStart ) ) ) | this_RuleAtomic_3= ruleRuleAtomic )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==26) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_ID||LA8_0==27||(LA8_0>=29 && LA8_0<=30)) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:479:2: ( () otherlv_1= '!' ( (lv_formula_2_0= ruleRuleStart ) ) )
                    {
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:479:2: ( () otherlv_1= '!' ( (lv_formula_2_0= ruleRuleStart ) ) )
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:479:3: () otherlv_1= '!' ( (lv_formula_2_0= ruleRuleStart ) )
                    {
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:479:3: ()
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:480:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getRuleUnaryPropositionalLogicAccess().getNotAction_0_0(),
                                current);
                        

                    }

                    otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleRuleUnaryPropositionalLogic1097); 

                        	newLeafNode(otherlv_1, grammarAccess.getRuleUnaryPropositionalLogicAccess().getExclamationMarkKeyword_0_1());
                        
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:489:1: ( (lv_formula_2_0= ruleRuleStart ) )
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:490:1: (lv_formula_2_0= ruleRuleStart )
                    {
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:490:1: (lv_formula_2_0= ruleRuleStart )
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:491:3: lv_formula_2_0= ruleRuleStart
                    {
                     
                    	        newCompositeNode(grammarAccess.getRuleUnaryPropositionalLogicAccess().getFormulaRuleStartParserRuleCall_0_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleRuleStart_in_ruleRuleUnaryPropositionalLogic1118);
                    lv_formula_2_0=ruleRuleStart();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRuleUnaryPropositionalLogicRule());
                    	        }
                           		set(
                           			current, 
                           			"formula",
                            		lv_formula_2_0, 
                            		"RuleStart");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:509:5: this_RuleAtomic_3= ruleRuleAtomic
                    {
                     
                            newCompositeNode(grammarAccess.getRuleUnaryPropositionalLogicAccess().getRuleAtomicParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRuleAtomic_in_ruleRuleUnaryPropositionalLogic1147);
                    this_RuleAtomic_3=ruleRuleAtomic();

                    state._fsp--;

                     
                            current = this_RuleAtomic_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleUnaryPropositionalLogic"


    // $ANTLR start "entryRuleRuleAtomic"
    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:525:1: entryRuleRuleAtomic returns [EObject current=null] : iv_ruleRuleAtomic= ruleRuleAtomic EOF ;
    public final EObject entryRuleRuleAtomic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleAtomic = null;


        try {
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:526:2: (iv_ruleRuleAtomic= ruleRuleAtomic EOF )
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:527:2: iv_ruleRuleAtomic= ruleRuleAtomic EOF
            {
             newCompositeNode(grammarAccess.getRuleAtomicRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleAtomic_in_entryRuleRuleAtomic1182);
            iv_ruleRuleAtomic=ruleRuleAtomic();

            state._fsp--;

             current =iv_ruleRuleAtomic; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleAtomic1192); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleAtomic"


    // $ANTLR start "ruleRuleAtomic"
    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:534:1: ruleRuleAtomic returns [EObject current=null] : ( (otherlv_0= '(' this_RuleStart_1= ruleRuleStart otherlv_2= ')' ) | ( () ( (lv_variable_4_0= RULE_ID ) ) ) | ( () otherlv_6= 'true' ) | ( () otherlv_8= 'false' ) ) ;
    public final EObject ruleRuleAtomic() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_variable_4_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject this_RuleStart_1 = null;


         enterRule(); 
            
        try {
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:537:28: ( ( (otherlv_0= '(' this_RuleStart_1= ruleRuleStart otherlv_2= ')' ) | ( () ( (lv_variable_4_0= RULE_ID ) ) ) | ( () otherlv_6= 'true' ) | ( () otherlv_8= 'false' ) ) )
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:538:1: ( (otherlv_0= '(' this_RuleStart_1= ruleRuleStart otherlv_2= ')' ) | ( () ( (lv_variable_4_0= RULE_ID ) ) ) | ( () otherlv_6= 'true' ) | ( () otherlv_8= 'false' ) )
            {
            // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:538:1: ( (otherlv_0= '(' this_RuleStart_1= ruleRuleStart otherlv_2= ')' ) | ( () ( (lv_variable_4_0= RULE_ID ) ) ) | ( () otherlv_6= 'true' ) | ( () otherlv_8= 'false' ) )
            int alt9=4;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt9=1;
                }
                break;
            case RULE_ID:
                {
                alt9=2;
                }
                break;
            case 29:
                {
                alt9=3;
                }
                break;
            case 30:
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:538:2: (otherlv_0= '(' this_RuleStart_1= ruleRuleStart otherlv_2= ')' )
                    {
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:538:2: (otherlv_0= '(' this_RuleStart_1= ruleRuleStart otherlv_2= ')' )
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:538:4: otherlv_0= '(' this_RuleStart_1= ruleRuleStart otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleRuleAtomic1230); 

                        	newLeafNode(otherlv_0, grammarAccess.getRuleAtomicAccess().getLeftParenthesisKeyword_0_0());
                        
                     
                            newCompositeNode(grammarAccess.getRuleAtomicAccess().getRuleStartParserRuleCall_0_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRuleStart_in_ruleRuleAtomic1252);
                    this_RuleStart_1=ruleRuleStart();

                    state._fsp--;

                     
                            current = this_RuleStart_1; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_2=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleRuleAtomic1263); 

                        	newLeafNode(otherlv_2, grammarAccess.getRuleAtomicAccess().getRightParenthesisKeyword_0_2());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:556:6: ( () ( (lv_variable_4_0= RULE_ID ) ) )
                    {
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:556:6: ( () ( (lv_variable_4_0= RULE_ID ) ) )
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:556:7: () ( (lv_variable_4_0= RULE_ID ) )
                    {
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:556:7: ()
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:557:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getRuleAtomicAccess().getRuleVariableUseAction_1_0(),
                                current);
                        

                    }

                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:562:2: ( (lv_variable_4_0= RULE_ID ) )
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:563:1: (lv_variable_4_0= RULE_ID )
                    {
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:563:1: (lv_variable_4_0= RULE_ID )
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:564:3: lv_variable_4_0= RULE_ID
                    {
                    lv_variable_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleAtomic1297); 

                    			newLeafNode(lv_variable_4_0, grammarAccess.getRuleAtomicAccess().getVariableIDTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getRuleAtomicRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"variable",
                            		lv_variable_4_0, 
                            		"ID");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:581:6: ( () otherlv_6= 'true' )
                    {
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:581:6: ( () otherlv_6= 'true' )
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:581:7: () otherlv_6= 'true'
                    {
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:581:7: ()
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:582:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getRuleAtomicAccess().getTrueAction_2_0(),
                                current);
                        

                    }

                    otherlv_6=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleRuleAtomic1331); 

                        	newLeafNode(otherlv_6, grammarAccess.getRuleAtomicAccess().getTrueKeyword_2_1());
                        

                    }


                    }
                    break;
                case 4 :
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:592:6: ( () otherlv_8= 'false' )
                    {
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:592:6: ( () otherlv_8= 'false' )
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:592:7: () otherlv_8= 'false'
                    {
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:592:7: ()
                    // ../transformation.ctllang2ctl/src-gen/transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.g:593:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getRuleAtomicAccess().getFalseAction_3_0(),
                                current);
                        

                    }

                    otherlv_8=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleRuleAtomic1360); 

                        	newLeafNode(otherlv_8, grammarAccess.getRuleAtomicAccess().getFalseKeyword_3_1());
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleAtomic"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRuleStart_in_entryRuleRuleStart75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleStart85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleArrow_in_ruleRuleStart131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleSimple_in_entryRuleRuleSimple165 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleSimple175 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleRuleSimple224 = new BitSet(new long[]{0x000000006C07F810L});
        public static final BitSet FOLLOW_12_in_ruleRuleSimple253 = new BitSet(new long[]{0x000000006C07F810L});
        public static final BitSet FOLLOW_13_in_ruleRuleSimple282 = new BitSet(new long[]{0x000000006C07F810L});
        public static final BitSet FOLLOW_14_in_ruleRuleSimple311 = new BitSet(new long[]{0x000000006C07F810L});
        public static final BitSet FOLLOW_15_in_ruleRuleSimple340 = new BitSet(new long[]{0x000000006C07F810L});
        public static final BitSet FOLLOW_16_in_ruleRuleSimple369 = new BitSet(new long[]{0x000000006C07F810L});
        public static final BitSet FOLLOW_ruleRuleStart_in_ruleRuleSimple392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleRuleSimple423 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_18_in_ruleRuleSimple452 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleRuleSimple466 = new BitSet(new long[]{0x000000006C07F810L});
        public static final BitSet FOLLOW_ruleRuleStart_in_ruleRuleSimple487 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleRuleSimple499 = new BitSet(new long[]{0x000000006C07F810L});
        public static final BitSet FOLLOW_ruleRuleStart_in_ruleRuleSimple520 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleRuleSimple532 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleUnaryPropositionalLogic_in_ruleRuleSimple561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleArrow_in_entryRuleRuleArrow596 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleArrow606 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleDisjunction_in_ruleRuleArrow653 = new BitSet(new long[]{0x0000000000C00002L});
        public static final BitSet FOLLOW_22_in_ruleRuleArrow676 = new BitSet(new long[]{0x000000006C07F810L});
        public static final BitSet FOLLOW_23_in_ruleRuleArrow705 = new BitSet(new long[]{0x000000006C07F810L});
        public static final BitSet FOLLOW_ruleRuleDisjunction_in_ruleRuleArrow728 = new BitSet(new long[]{0x0000000000C00002L});
        public static final BitSet FOLLOW_ruleRuleDisjunction_in_entryRuleRuleDisjunction766 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleDisjunction776 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleConjunction_in_ruleRuleDisjunction823 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_24_in_ruleRuleDisjunction844 = new BitSet(new long[]{0x000000006C07F810L});
        public static final BitSet FOLLOW_ruleRuleConjunction_in_ruleRuleDisjunction865 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_ruleRuleConjunction_in_entryRuleRuleConjunction903 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleConjunction913 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleSimple_in_ruleRuleConjunction960 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleRuleConjunction981 = new BitSet(new long[]{0x000000006C07F810L});
        public static final BitSet FOLLOW_ruleRuleSimple_in_ruleRuleConjunction1002 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_ruleRuleUnaryPropositionalLogic_in_entryRuleRuleUnaryPropositionalLogic1040 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleUnaryPropositionalLogic1050 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleRuleUnaryPropositionalLogic1097 = new BitSet(new long[]{0x000000006C07F810L});
        public static final BitSet FOLLOW_ruleRuleStart_in_ruleRuleUnaryPropositionalLogic1118 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleAtomic_in_ruleRuleUnaryPropositionalLogic1147 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleAtomic_in_entryRuleRuleAtomic1182 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleAtomic1192 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleRuleAtomic1230 = new BitSet(new long[]{0x000000006C07F810L});
        public static final BitSet FOLLOW_ruleRuleStart_in_ruleRuleAtomic1252 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleRuleAtomic1263 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleAtomic1297 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleRuleAtomic1331 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleRuleAtomic1360 = new BitSet(new long[]{0x0000000000000002L});
    }


}