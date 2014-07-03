package ltllang2ltl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import ltllang2ltl.services.LtlXtextGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalLtlXtextParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'U'", "'R'", "'S'", "'T'", "'G'", "'F'", "'X'", "'H'", "'O'", "'->'", "'<->'", "'|'", "'&'", "'!'", "'('", "')'", "'true'", "'false'"
    };
    public static final int RULE_ID=4;
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


        public InternalLtlXtextParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalLtlXtextParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalLtlXtextParser.tokenNames; }
    public String getGrammarFileName() { return "../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g"; }



     	private LtlXtextGrammarAccess grammarAccess;
     	
        public InternalLtlXtextParser(TokenStream input, LtlXtextGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "RuleStart";	
       	}
       	
       	@Override
       	protected LtlXtextGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleRuleStart"
    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:67:1: entryRuleRuleStart returns [EObject current=null] : iv_ruleRuleStart= ruleRuleStart EOF ;
    public final EObject entryRuleRuleStart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleStart = null;


        try {
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:68:2: (iv_ruleRuleStart= ruleRuleStart EOF )
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:69:2: iv_ruleRuleStart= ruleRuleStart EOF
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
    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:76:1: ruleRuleStart returns [EObject current=null] : (this_RuleArrow_0= ruleRuleArrow ( ( ( () otherlv_2= 'U' ) | ( () otherlv_4= 'R' ) | ( () otherlv_6= 'S' ) | ( () otherlv_8= 'T' ) ) ( (lv_right_9_0= ruleRuleArrow ) ) )* ) ;
    public final EObject ruleRuleStart() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject this_RuleArrow_0 = null;

        EObject lv_right_9_0 = null;


         enterRule(); 
            
        try {
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:79:28: ( (this_RuleArrow_0= ruleRuleArrow ( ( ( () otherlv_2= 'U' ) | ( () otherlv_4= 'R' ) | ( () otherlv_6= 'S' ) | ( () otherlv_8= 'T' ) ) ( (lv_right_9_0= ruleRuleArrow ) ) )* ) )
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:80:1: (this_RuleArrow_0= ruleRuleArrow ( ( ( () otherlv_2= 'U' ) | ( () otherlv_4= 'R' ) | ( () otherlv_6= 'S' ) | ( () otherlv_8= 'T' ) ) ( (lv_right_9_0= ruleRuleArrow ) ) )* )
            {
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:80:1: (this_RuleArrow_0= ruleRuleArrow ( ( ( () otherlv_2= 'U' ) | ( () otherlv_4= 'R' ) | ( () otherlv_6= 'S' ) | ( () otherlv_8= 'T' ) ) ( (lv_right_9_0= ruleRuleArrow ) ) )* )
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:81:5: this_RuleArrow_0= ruleRuleArrow ( ( ( () otherlv_2= 'U' ) | ( () otherlv_4= 'R' ) | ( () otherlv_6= 'S' ) | ( () otherlv_8= 'T' ) ) ( (lv_right_9_0= ruleRuleArrow ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getRuleStartAccess().getRuleArrowParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleRuleArrow_in_ruleRuleStart132);
            this_RuleArrow_0=ruleRuleArrow();

            state._fsp--;

             
                    current = this_RuleArrow_0; 
                    afterParserOrEnumRuleCall();
                
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:89:1: ( ( ( () otherlv_2= 'U' ) | ( () otherlv_4= 'R' ) | ( () otherlv_6= 'S' ) | ( () otherlv_8= 'T' ) ) ( (lv_right_9_0= ruleRuleArrow ) ) )*
            loop2:
            do {
                int alt2=2;
                switch ( input.LA(1) ) {
                case 11:
                    {
                    alt2=1;
                    }
                    break;
                case 12:
                    {
                    alt2=1;
                    }
                    break;
                case 13:
                    {
                    alt2=1;
                    }
                    break;
                case 14:
                    {
                    alt2=1;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:89:2: ( ( () otherlv_2= 'U' ) | ( () otherlv_4= 'R' ) | ( () otherlv_6= 'S' ) | ( () otherlv_8= 'T' ) ) ( (lv_right_9_0= ruleRuleArrow ) )
            	    {
            	    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:89:2: ( ( () otherlv_2= 'U' ) | ( () otherlv_4= 'R' ) | ( () otherlv_6= 'S' ) | ( () otherlv_8= 'T' ) )
            	    int alt1=4;
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
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 1, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt1) {
            	        case 1 :
            	            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:89:3: ( () otherlv_2= 'U' )
            	            {
            	            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:89:3: ( () otherlv_2= 'U' )
            	            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:89:4: () otherlv_2= 'U'
            	            {
            	            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:89:4: ()
            	            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:90:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getRuleStartAccess().getUntilLeftAction_1_0_0_0(),
            	                        current);
            	                

            	            }

            	            otherlv_2=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleRuleStart155); 

            	                	newLeafNode(otherlv_2, grammarAccess.getRuleStartAccess().getUKeyword_1_0_0_1());
            	                

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:100:6: ( () otherlv_4= 'R' )
            	            {
            	            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:100:6: ( () otherlv_4= 'R' )
            	            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:100:7: () otherlv_4= 'R'
            	            {
            	            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:100:7: ()
            	            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:101:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getRuleStartAccess().getReleasesLeftAction_1_0_1_0(),
            	                        current);
            	                

            	            }

            	            otherlv_4=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleRuleStart184); 

            	                	newLeafNode(otherlv_4, grammarAccess.getRuleStartAccess().getRKeyword_1_0_1_1());
            	                

            	            }


            	            }
            	            break;
            	        case 3 :
            	            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:111:6: ( () otherlv_6= 'S' )
            	            {
            	            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:111:6: ( () otherlv_6= 'S' )
            	            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:111:7: () otherlv_6= 'S'
            	            {
            	            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:111:7: ()
            	            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:112:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getRuleStartAccess().getSinceLeftAction_1_0_2_0(),
            	                        current);
            	                

            	            }

            	            otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleRuleStart213); 

            	                	newLeafNode(otherlv_6, grammarAccess.getRuleStartAccess().getSKeyword_1_0_2_1());
            	                

            	            }


            	            }
            	            break;
            	        case 4 :
            	            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:122:6: ( () otherlv_8= 'T' )
            	            {
            	            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:122:6: ( () otherlv_8= 'T' )
            	            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:122:7: () otherlv_8= 'T'
            	            {
            	            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:122:7: ()
            	            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:123:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getRuleStartAccess().getTriggeredLeftAction_1_0_3_0(),
            	                        current);
            	                

            	            }

            	            otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleRuleStart242); 

            	                	newLeafNode(otherlv_8, grammarAccess.getRuleStartAccess().getTKeyword_1_0_3_1());
            	                

            	            }


            	            }
            	            break;

            	    }

            	    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:132:3: ( (lv_right_9_0= ruleRuleArrow ) )
            	    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:133:1: (lv_right_9_0= ruleRuleArrow )
            	    {
            	    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:133:1: (lv_right_9_0= ruleRuleArrow )
            	    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:134:3: lv_right_9_0= ruleRuleArrow
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRuleStartAccess().getRightRuleArrowParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleRuleArrow_in_ruleRuleStart265);
            	    lv_right_9_0=ruleRuleArrow();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRuleStartRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_9_0, 
            	            		"RuleArrow");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end "ruleRuleStart"


    // $ANTLR start "entryRuleRuleSimple"
    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:158:1: entryRuleRuleSimple returns [EObject current=null] : iv_ruleRuleSimple= ruleRuleSimple EOF ;
    public final EObject entryRuleRuleSimple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleSimple = null;


        try {
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:159:2: (iv_ruleRuleSimple= ruleRuleSimple EOF )
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:160:2: iv_ruleRuleSimple= ruleRuleSimple EOF
            {
             newCompositeNode(grammarAccess.getRuleSimpleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleSimple_in_entryRuleRuleSimple303);
            iv_ruleRuleSimple=ruleRuleSimple();

            state._fsp--;

             current =iv_ruleRuleSimple; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleSimple313); 

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
    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:167:1: ruleRuleSimple returns [EObject current=null] : ( ( ( ( () otherlv_1= 'G' ) | ( () otherlv_3= 'F' ) | ( () otherlv_5= 'X' ) | ( () otherlv_7= 'H' ) | ( () otherlv_9= 'O' ) ) ( (lv_formula_10_0= ruleRuleStart ) ) ) | this_RuleUnaryPropositionalLogic_11= ruleRuleUnaryPropositionalLogic ) ;
    public final EObject ruleRuleSimple() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_formula_10_0 = null;

        EObject this_RuleUnaryPropositionalLogic_11 = null;


         enterRule(); 
            
        try {
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:170:28: ( ( ( ( ( () otherlv_1= 'G' ) | ( () otherlv_3= 'F' ) | ( () otherlv_5= 'X' ) | ( () otherlv_7= 'H' ) | ( () otherlv_9= 'O' ) ) ( (lv_formula_10_0= ruleRuleStart ) ) ) | this_RuleUnaryPropositionalLogic_11= ruleRuleUnaryPropositionalLogic ) )
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:171:1: ( ( ( ( () otherlv_1= 'G' ) | ( () otherlv_3= 'F' ) | ( () otherlv_5= 'X' ) | ( () otherlv_7= 'H' ) | ( () otherlv_9= 'O' ) ) ( (lv_formula_10_0= ruleRuleStart ) ) ) | this_RuleUnaryPropositionalLogic_11= ruleRuleUnaryPropositionalLogic )
            {
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:171:1: ( ( ( ( () otherlv_1= 'G' ) | ( () otherlv_3= 'F' ) | ( () otherlv_5= 'X' ) | ( () otherlv_7= 'H' ) | ( () otherlv_9= 'O' ) ) ( (lv_formula_10_0= ruleRuleStart ) ) ) | this_RuleUnaryPropositionalLogic_11= ruleRuleUnaryPropositionalLogic )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=15 && LA4_0<=19)) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_ID||(LA4_0>=24 && LA4_0<=25)||(LA4_0>=27 && LA4_0<=28)) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:171:2: ( ( ( () otherlv_1= 'G' ) | ( () otherlv_3= 'F' ) | ( () otherlv_5= 'X' ) | ( () otherlv_7= 'H' ) | ( () otherlv_9= 'O' ) ) ( (lv_formula_10_0= ruleRuleStart ) ) )
                    {
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:171:2: ( ( ( () otherlv_1= 'G' ) | ( () otherlv_3= 'F' ) | ( () otherlv_5= 'X' ) | ( () otherlv_7= 'H' ) | ( () otherlv_9= 'O' ) ) ( (lv_formula_10_0= ruleRuleStart ) ) )
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:171:3: ( ( () otherlv_1= 'G' ) | ( () otherlv_3= 'F' ) | ( () otherlv_5= 'X' ) | ( () otherlv_7= 'H' ) | ( () otherlv_9= 'O' ) ) ( (lv_formula_10_0= ruleRuleStart ) )
                    {
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:171:3: ( ( () otherlv_1= 'G' ) | ( () otherlv_3= 'F' ) | ( () otherlv_5= 'X' ) | ( () otherlv_7= 'H' ) | ( () otherlv_9= 'O' ) )
                    int alt3=5;
                    switch ( input.LA(1) ) {
                    case 15:
                        {
                        alt3=1;
                        }
                        break;
                    case 16:
                        {
                        alt3=2;
                        }
                        break;
                    case 17:
                        {
                        alt3=3;
                        }
                        break;
                    case 18:
                        {
                        alt3=4;
                        }
                        break;
                    case 19:
                        {
                        alt3=5;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 0, input);

                        throw nvae;
                    }

                    switch (alt3) {
                        case 1 :
                            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:171:4: ( () otherlv_1= 'G' )
                            {
                            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:171:4: ( () otherlv_1= 'G' )
                            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:171:5: () otherlv_1= 'G'
                            {
                            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:171:5: ()
                            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:172:5: 
                            {

                                    current = forceCreateModelElement(
                                        grammarAccess.getRuleSimpleAccess().getGloballyAction_0_0_0_0(),
                                        current);
                                

                            }

                            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleRuleSimple362); 

                                	newLeafNode(otherlv_1, grammarAccess.getRuleSimpleAccess().getGKeyword_0_0_0_1());
                                

                            }


                            }
                            break;
                        case 2 :
                            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:182:6: ( () otherlv_3= 'F' )
                            {
                            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:182:6: ( () otherlv_3= 'F' )
                            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:182:7: () otherlv_3= 'F'
                            {
                            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:182:7: ()
                            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:183:5: 
                            {

                                    current = forceCreateModelElement(
                                        grammarAccess.getRuleSimpleAccess().getFutureAction_0_0_1_0(),
                                        current);
                                

                            }

                            otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleRuleSimple391); 

                                	newLeafNode(otherlv_3, grammarAccess.getRuleSimpleAccess().getFKeyword_0_0_1_1());
                                

                            }


                            }
                            break;
                        case 3 :
                            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:193:6: ( () otherlv_5= 'X' )
                            {
                            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:193:6: ( () otherlv_5= 'X' )
                            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:193:7: () otherlv_5= 'X'
                            {
                            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:193:7: ()
                            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:194:5: 
                            {

                                    current = forceCreateModelElement(
                                        grammarAccess.getRuleSimpleAccess().getNextAction_0_0_2_0(),
                                        current);
                                

                            }

                            otherlv_5=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleRuleSimple420); 

                                	newLeafNode(otherlv_5, grammarAccess.getRuleSimpleAccess().getXKeyword_0_0_2_1());
                                

                            }


                            }
                            break;
                        case 4 :
                            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:204:6: ( () otherlv_7= 'H' )
                            {
                            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:204:6: ( () otherlv_7= 'H' )
                            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:204:7: () otherlv_7= 'H'
                            {
                            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:204:7: ()
                            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:205:5: 
                            {

                                    current = forceCreateModelElement(
                                        grammarAccess.getRuleSimpleAccess().getHistoricallyAction_0_0_3_0(),
                                        current);
                                

                            }

                            otherlv_7=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleRuleSimple449); 

                                	newLeafNode(otherlv_7, grammarAccess.getRuleSimpleAccess().getHKeyword_0_0_3_1());
                                

                            }


                            }
                            break;
                        case 5 :
                            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:215:6: ( () otherlv_9= 'O' )
                            {
                            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:215:6: ( () otherlv_9= 'O' )
                            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:215:7: () otherlv_9= 'O'
                            {
                            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:215:7: ()
                            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:216:5: 
                            {

                                    current = forceCreateModelElement(
                                        grammarAccess.getRuleSimpleAccess().getOnceAction_0_0_4_0(),
                                        current);
                                

                            }

                            otherlv_9=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleRuleSimple478); 

                                	newLeafNode(otherlv_9, grammarAccess.getRuleSimpleAccess().getOKeyword_0_0_4_1());
                                

                            }


                            }
                            break;

                    }

                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:225:3: ( (lv_formula_10_0= ruleRuleStart ) )
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:226:1: (lv_formula_10_0= ruleRuleStart )
                    {
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:226:1: (lv_formula_10_0= ruleRuleStart )
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:227:3: lv_formula_10_0= ruleRuleStart
                    {
                     
                    	        newCompositeNode(grammarAccess.getRuleSimpleAccess().getFormulaRuleStartParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleRuleStart_in_ruleRuleSimple501);
                    lv_formula_10_0=ruleRuleStart();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRuleSimpleRule());
                    	        }
                           		set(
                           			current, 
                           			"formula",
                            		lv_formula_10_0, 
                            		"RuleStart");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:245:5: this_RuleUnaryPropositionalLogic_11= ruleRuleUnaryPropositionalLogic
                    {
                     
                            newCompositeNode(grammarAccess.getRuleSimpleAccess().getRuleUnaryPropositionalLogicParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRuleUnaryPropositionalLogic_in_ruleRuleSimple530);
                    this_RuleUnaryPropositionalLogic_11=ruleRuleUnaryPropositionalLogic();

                    state._fsp--;

                     
                            current = this_RuleUnaryPropositionalLogic_11; 
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
    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:261:1: entryRuleRuleArrow returns [EObject current=null] : iv_ruleRuleArrow= ruleRuleArrow EOF ;
    public final EObject entryRuleRuleArrow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleArrow = null;


        try {
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:262:2: (iv_ruleRuleArrow= ruleRuleArrow EOF )
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:263:2: iv_ruleRuleArrow= ruleRuleArrow EOF
            {
             newCompositeNode(grammarAccess.getRuleArrowRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleArrow_in_entryRuleRuleArrow565);
            iv_ruleRuleArrow=ruleRuleArrow();

            state._fsp--;

             current =iv_ruleRuleArrow; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleArrow575); 

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
    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:270:1: ruleRuleArrow returns [EObject current=null] : (this_RuleDisjunction_0= ruleRuleDisjunction ( ( ( () otherlv_2= '->' ) | ( () otherlv_4= '<->' ) ) ( (lv_right_5_0= ruleRuleDisjunction ) ) )* ) ;
    public final EObject ruleRuleArrow() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_RuleDisjunction_0 = null;

        EObject lv_right_5_0 = null;


         enterRule(); 
            
        try {
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:273:28: ( (this_RuleDisjunction_0= ruleRuleDisjunction ( ( ( () otherlv_2= '->' ) | ( () otherlv_4= '<->' ) ) ( (lv_right_5_0= ruleRuleDisjunction ) ) )* ) )
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:274:1: (this_RuleDisjunction_0= ruleRuleDisjunction ( ( ( () otherlv_2= '->' ) | ( () otherlv_4= '<->' ) ) ( (lv_right_5_0= ruleRuleDisjunction ) ) )* )
            {
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:274:1: (this_RuleDisjunction_0= ruleRuleDisjunction ( ( ( () otherlv_2= '->' ) | ( () otherlv_4= '<->' ) ) ( (lv_right_5_0= ruleRuleDisjunction ) ) )* )
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:275:5: this_RuleDisjunction_0= ruleRuleDisjunction ( ( ( () otherlv_2= '->' ) | ( () otherlv_4= '<->' ) ) ( (lv_right_5_0= ruleRuleDisjunction ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getRuleArrowAccess().getRuleDisjunctionParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleRuleDisjunction_in_ruleRuleArrow622);
            this_RuleDisjunction_0=ruleRuleDisjunction();

            state._fsp--;

             
                    current = this_RuleDisjunction_0; 
                    afterParserOrEnumRuleCall();
                
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:283:1: ( ( ( () otherlv_2= '->' ) | ( () otherlv_4= '<->' ) ) ( (lv_right_5_0= ruleRuleDisjunction ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==20) ) {
                    alt6=1;
                }
                else if ( (LA6_0==21) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:283:2: ( ( () otherlv_2= '->' ) | ( () otherlv_4= '<->' ) ) ( (lv_right_5_0= ruleRuleDisjunction ) )
            	    {
            	    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:283:2: ( ( () otherlv_2= '->' ) | ( () otherlv_4= '<->' ) )
            	    int alt5=2;
            	    int LA5_0 = input.LA(1);

            	    if ( (LA5_0==20) ) {
            	        alt5=1;
            	    }
            	    else if ( (LA5_0==21) ) {
            	        alt5=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 5, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt5) {
            	        case 1 :
            	            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:283:3: ( () otherlv_2= '->' )
            	            {
            	            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:283:3: ( () otherlv_2= '->' )
            	            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:283:4: () otherlv_2= '->'
            	            {
            	            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:283:4: ()
            	            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:284:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getRuleArrowAccess().getImplicationLeftAction_1_0_0_0(),
            	                        current);
            	                

            	            }

            	            otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleRuleArrow645); 

            	                	newLeafNode(otherlv_2, grammarAccess.getRuleArrowAccess().getHyphenMinusGreaterThanSignKeyword_1_0_0_1());
            	                

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:294:6: ( () otherlv_4= '<->' )
            	            {
            	            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:294:6: ( () otherlv_4= '<->' )
            	            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:294:7: () otherlv_4= '<->'
            	            {
            	            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:294:7: ()
            	            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:295:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getRuleArrowAccess().getEquivalenceLeftAction_1_0_1_0(),
            	                        current);
            	                

            	            }

            	            otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleRuleArrow674); 

            	                	newLeafNode(otherlv_4, grammarAccess.getRuleArrowAccess().getLessThanSignHyphenMinusGreaterThanSignKeyword_1_0_1_1());
            	                

            	            }


            	            }
            	            break;

            	    }

            	    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:304:3: ( (lv_right_5_0= ruleRuleDisjunction ) )
            	    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:305:1: (lv_right_5_0= ruleRuleDisjunction )
            	    {
            	    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:305:1: (lv_right_5_0= ruleRuleDisjunction )
            	    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:306:3: lv_right_5_0= ruleRuleDisjunction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRuleArrowAccess().getRightRuleDisjunctionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleRuleDisjunction_in_ruleRuleArrow697);
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
    // $ANTLR end "ruleRuleArrow"


    // $ANTLR start "entryRuleRuleDisjunction"
    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:330:1: entryRuleRuleDisjunction returns [EObject current=null] : iv_ruleRuleDisjunction= ruleRuleDisjunction EOF ;
    public final EObject entryRuleRuleDisjunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleDisjunction = null;


        try {
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:331:2: (iv_ruleRuleDisjunction= ruleRuleDisjunction EOF )
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:332:2: iv_ruleRuleDisjunction= ruleRuleDisjunction EOF
            {
             newCompositeNode(grammarAccess.getRuleDisjunctionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleDisjunction_in_entryRuleRuleDisjunction735);
            iv_ruleRuleDisjunction=ruleRuleDisjunction();

            state._fsp--;

             current =iv_ruleRuleDisjunction; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleDisjunction745); 

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
    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:339:1: ruleRuleDisjunction returns [EObject current=null] : (this_RuleConjunction_0= ruleRuleConjunction ( () otherlv_2= '|' ( (lv_right_3_0= ruleRuleConjunction ) ) )* ) ;
    public final EObject ruleRuleDisjunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_RuleConjunction_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:342:28: ( (this_RuleConjunction_0= ruleRuleConjunction ( () otherlv_2= '|' ( (lv_right_3_0= ruleRuleConjunction ) ) )* ) )
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:343:1: (this_RuleConjunction_0= ruleRuleConjunction ( () otherlv_2= '|' ( (lv_right_3_0= ruleRuleConjunction ) ) )* )
            {
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:343:1: (this_RuleConjunction_0= ruleRuleConjunction ( () otherlv_2= '|' ( (lv_right_3_0= ruleRuleConjunction ) ) )* )
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:344:5: this_RuleConjunction_0= ruleRuleConjunction ( () otherlv_2= '|' ( (lv_right_3_0= ruleRuleConjunction ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getRuleDisjunctionAccess().getRuleConjunctionParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleRuleConjunction_in_ruleRuleDisjunction792);
            this_RuleConjunction_0=ruleRuleConjunction();

            state._fsp--;

             
                    current = this_RuleConjunction_0; 
                    afterParserOrEnumRuleCall();
                
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:352:1: ( () otherlv_2= '|' ( (lv_right_3_0= ruleRuleConjunction ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==22) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:352:2: () otherlv_2= '|' ( (lv_right_3_0= ruleRuleConjunction ) )
            	    {
            	    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:352:2: ()
            	    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:353:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getRuleDisjunctionAccess().getOrLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleRuleDisjunction813); 

            	        	newLeafNode(otherlv_2, grammarAccess.getRuleDisjunctionAccess().getVerticalLineKeyword_1_1());
            	        
            	    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:362:1: ( (lv_right_3_0= ruleRuleConjunction ) )
            	    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:363:1: (lv_right_3_0= ruleRuleConjunction )
            	    {
            	    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:363:1: (lv_right_3_0= ruleRuleConjunction )
            	    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:364:3: lv_right_3_0= ruleRuleConjunction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRuleDisjunctionAccess().getRightRuleConjunctionParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleRuleConjunction_in_ruleRuleDisjunction834);
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
    // $ANTLR end "ruleRuleDisjunction"


    // $ANTLR start "entryRuleRuleConjunction"
    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:388:1: entryRuleRuleConjunction returns [EObject current=null] : iv_ruleRuleConjunction= ruleRuleConjunction EOF ;
    public final EObject entryRuleRuleConjunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleConjunction = null;


        try {
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:389:2: (iv_ruleRuleConjunction= ruleRuleConjunction EOF )
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:390:2: iv_ruleRuleConjunction= ruleRuleConjunction EOF
            {
             newCompositeNode(grammarAccess.getRuleConjunctionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleConjunction_in_entryRuleRuleConjunction872);
            iv_ruleRuleConjunction=ruleRuleConjunction();

            state._fsp--;

             current =iv_ruleRuleConjunction; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleConjunction882); 

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
    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:397:1: ruleRuleConjunction returns [EObject current=null] : (this_RuleSimple_0= ruleRuleSimple ( () otherlv_2= '&' ( (lv_right_3_0= ruleRuleSimple ) ) )* ) ;
    public final EObject ruleRuleConjunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_RuleSimple_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:400:28: ( (this_RuleSimple_0= ruleRuleSimple ( () otherlv_2= '&' ( (lv_right_3_0= ruleRuleSimple ) ) )* ) )
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:401:1: (this_RuleSimple_0= ruleRuleSimple ( () otherlv_2= '&' ( (lv_right_3_0= ruleRuleSimple ) ) )* )
            {
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:401:1: (this_RuleSimple_0= ruleRuleSimple ( () otherlv_2= '&' ( (lv_right_3_0= ruleRuleSimple ) ) )* )
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:402:5: this_RuleSimple_0= ruleRuleSimple ( () otherlv_2= '&' ( (lv_right_3_0= ruleRuleSimple ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getRuleConjunctionAccess().getRuleSimpleParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleRuleSimple_in_ruleRuleConjunction929);
            this_RuleSimple_0=ruleRuleSimple();

            state._fsp--;

             
                    current = this_RuleSimple_0; 
                    afterParserOrEnumRuleCall();
                
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:410:1: ( () otherlv_2= '&' ( (lv_right_3_0= ruleRuleSimple ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==23) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:410:2: () otherlv_2= '&' ( (lv_right_3_0= ruleRuleSimple ) )
            	    {
            	    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:410:2: ()
            	    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:411:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getRuleConjunctionAccess().getAndLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleRuleConjunction950); 

            	        	newLeafNode(otherlv_2, grammarAccess.getRuleConjunctionAccess().getAmpersandKeyword_1_1());
            	        
            	    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:420:1: ( (lv_right_3_0= ruleRuleSimple ) )
            	    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:421:1: (lv_right_3_0= ruleRuleSimple )
            	    {
            	    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:421:1: (lv_right_3_0= ruleRuleSimple )
            	    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:422:3: lv_right_3_0= ruleRuleSimple
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRuleConjunctionAccess().getRightRuleSimpleParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleRuleSimple_in_ruleRuleConjunction971);
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
            	    break loop8;
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
    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:446:1: entryRuleRuleUnaryPropositionalLogic returns [EObject current=null] : iv_ruleRuleUnaryPropositionalLogic= ruleRuleUnaryPropositionalLogic EOF ;
    public final EObject entryRuleRuleUnaryPropositionalLogic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleUnaryPropositionalLogic = null;


        try {
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:447:2: (iv_ruleRuleUnaryPropositionalLogic= ruleRuleUnaryPropositionalLogic EOF )
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:448:2: iv_ruleRuleUnaryPropositionalLogic= ruleRuleUnaryPropositionalLogic EOF
            {
             newCompositeNode(grammarAccess.getRuleUnaryPropositionalLogicRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleUnaryPropositionalLogic_in_entryRuleRuleUnaryPropositionalLogic1009);
            iv_ruleRuleUnaryPropositionalLogic=ruleRuleUnaryPropositionalLogic();

            state._fsp--;

             current =iv_ruleRuleUnaryPropositionalLogic; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleUnaryPropositionalLogic1019); 

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
    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:455:1: ruleRuleUnaryPropositionalLogic returns [EObject current=null] : ( ( () otherlv_1= '!' ( (lv_formula_2_0= ruleRuleStart ) ) ) | this_RuleAtomic_3= ruleRuleAtomic ) ;
    public final EObject ruleRuleUnaryPropositionalLogic() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_formula_2_0 = null;

        EObject this_RuleAtomic_3 = null;


         enterRule(); 
            
        try {
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:458:28: ( ( ( () otherlv_1= '!' ( (lv_formula_2_0= ruleRuleStart ) ) ) | this_RuleAtomic_3= ruleRuleAtomic ) )
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:459:1: ( ( () otherlv_1= '!' ( (lv_formula_2_0= ruleRuleStart ) ) ) | this_RuleAtomic_3= ruleRuleAtomic )
            {
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:459:1: ( ( () otherlv_1= '!' ( (lv_formula_2_0= ruleRuleStart ) ) ) | this_RuleAtomic_3= ruleRuleAtomic )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_ID||LA9_0==25||(LA9_0>=27 && LA9_0<=28)) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:459:2: ( () otherlv_1= '!' ( (lv_formula_2_0= ruleRuleStart ) ) )
                    {
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:459:2: ( () otherlv_1= '!' ( (lv_formula_2_0= ruleRuleStart ) ) )
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:459:3: () otherlv_1= '!' ( (lv_formula_2_0= ruleRuleStart ) )
                    {
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:459:3: ()
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:460:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getRuleUnaryPropositionalLogicAccess().getNotAction_0_0(),
                                current);
                        

                    }

                    otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleRuleUnaryPropositionalLogic1066); 

                        	newLeafNode(otherlv_1, grammarAccess.getRuleUnaryPropositionalLogicAccess().getExclamationMarkKeyword_0_1());
                        
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:469:1: ( (lv_formula_2_0= ruleRuleStart ) )
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:470:1: (lv_formula_2_0= ruleRuleStart )
                    {
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:470:1: (lv_formula_2_0= ruleRuleStart )
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:471:3: lv_formula_2_0= ruleRuleStart
                    {
                     
                    	        newCompositeNode(grammarAccess.getRuleUnaryPropositionalLogicAccess().getFormulaRuleStartParserRuleCall_0_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleRuleStart_in_ruleRuleUnaryPropositionalLogic1087);
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
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:489:5: this_RuleAtomic_3= ruleRuleAtomic
                    {
                     
                            newCompositeNode(grammarAccess.getRuleUnaryPropositionalLogicAccess().getRuleAtomicParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRuleAtomic_in_ruleRuleUnaryPropositionalLogic1116);
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
    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:505:1: entryRuleRuleAtomic returns [EObject current=null] : iv_ruleRuleAtomic= ruleRuleAtomic EOF ;
    public final EObject entryRuleRuleAtomic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleAtomic = null;


        try {
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:506:2: (iv_ruleRuleAtomic= ruleRuleAtomic EOF )
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:507:2: iv_ruleRuleAtomic= ruleRuleAtomic EOF
            {
             newCompositeNode(grammarAccess.getRuleAtomicRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleAtomic_in_entryRuleRuleAtomic1151);
            iv_ruleRuleAtomic=ruleRuleAtomic();

            state._fsp--;

             current =iv_ruleRuleAtomic; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleAtomic1161); 

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
    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:514:1: ruleRuleAtomic returns [EObject current=null] : ( (otherlv_0= '(' this_RuleStart_1= ruleRuleStart otherlv_2= ')' ) | ( () ( (lv_variable_4_0= RULE_ID ) ) ) | ( () otherlv_6= 'true' ) | ( () otherlv_8= 'false' ) ) ;
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
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:517:28: ( ( (otherlv_0= '(' this_RuleStart_1= ruleRuleStart otherlv_2= ')' ) | ( () ( (lv_variable_4_0= RULE_ID ) ) ) | ( () otherlv_6= 'true' ) | ( () otherlv_8= 'false' ) ) )
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:518:1: ( (otherlv_0= '(' this_RuleStart_1= ruleRuleStart otherlv_2= ')' ) | ( () ( (lv_variable_4_0= RULE_ID ) ) ) | ( () otherlv_6= 'true' ) | ( () otherlv_8= 'false' ) )
            {
            // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:518:1: ( (otherlv_0= '(' this_RuleStart_1= ruleRuleStart otherlv_2= ')' ) | ( () ( (lv_variable_4_0= RULE_ID ) ) ) | ( () otherlv_6= 'true' ) | ( () otherlv_8= 'false' ) )
            int alt10=4;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt10=1;
                }
                break;
            case RULE_ID:
                {
                alt10=2;
                }
                break;
            case 27:
                {
                alt10=3;
                }
                break;
            case 28:
                {
                alt10=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:518:2: (otherlv_0= '(' this_RuleStart_1= ruleRuleStart otherlv_2= ')' )
                    {
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:518:2: (otherlv_0= '(' this_RuleStart_1= ruleRuleStart otherlv_2= ')' )
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:518:4: otherlv_0= '(' this_RuleStart_1= ruleRuleStart otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleRuleAtomic1199); 

                        	newLeafNode(otherlv_0, grammarAccess.getRuleAtomicAccess().getLeftParenthesisKeyword_0_0());
                        
                     
                            newCompositeNode(grammarAccess.getRuleAtomicAccess().getRuleStartParserRuleCall_0_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRuleStart_in_ruleRuleAtomic1221);
                    this_RuleStart_1=ruleRuleStart();

                    state._fsp--;

                     
                            current = this_RuleStart_1; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_2=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleRuleAtomic1232); 

                        	newLeafNode(otherlv_2, grammarAccess.getRuleAtomicAccess().getRightParenthesisKeyword_0_2());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:536:6: ( () ( (lv_variable_4_0= RULE_ID ) ) )
                    {
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:536:6: ( () ( (lv_variable_4_0= RULE_ID ) ) )
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:536:7: () ( (lv_variable_4_0= RULE_ID ) )
                    {
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:536:7: ()
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:537:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getRuleAtomicAccess().getRuleVariableUseAction_1_0(),
                                current);
                        

                    }

                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:542:2: ( (lv_variable_4_0= RULE_ID ) )
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:543:1: (lv_variable_4_0= RULE_ID )
                    {
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:543:1: (lv_variable_4_0= RULE_ID )
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:544:3: lv_variable_4_0= RULE_ID
                    {
                    lv_variable_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleAtomic1266); 

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
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:561:6: ( () otherlv_6= 'true' )
                    {
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:561:6: ( () otherlv_6= 'true' )
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:561:7: () otherlv_6= 'true'
                    {
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:561:7: ()
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:562:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getRuleAtomicAccess().getTrueAction_2_0(),
                                current);
                        

                    }

                    otherlv_6=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleRuleAtomic1300); 

                        	newLeafNode(otherlv_6, grammarAccess.getRuleAtomicAccess().getTrueKeyword_2_1());
                        

                    }


                    }
                    break;
                case 4 :
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:572:6: ( () otherlv_8= 'false' )
                    {
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:572:6: ( () otherlv_8= 'false' )
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:572:7: () otherlv_8= 'false'
                    {
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:572:7: ()
                    // ../transformation.ltllang2ltl/src-gen/ltllang2ltl/parser/antlr/internal/InternalLtlXtext.g:573:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getRuleAtomicAccess().getFalseAction_3_0(),
                                current);
                        

                    }

                    otherlv_8=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleRuleAtomic1329); 

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
        public static final BitSet FOLLOW_ruleRuleArrow_in_ruleRuleStart132 = new BitSet(new long[]{0x0000000000007802L});
        public static final BitSet FOLLOW_11_in_ruleRuleStart155 = new BitSet(new long[]{0x000000001B0F8010L});
        public static final BitSet FOLLOW_12_in_ruleRuleStart184 = new BitSet(new long[]{0x000000001B0F8010L});
        public static final BitSet FOLLOW_13_in_ruleRuleStart213 = new BitSet(new long[]{0x000000001B0F8010L});
        public static final BitSet FOLLOW_14_in_ruleRuleStart242 = new BitSet(new long[]{0x000000001B0F8010L});
        public static final BitSet FOLLOW_ruleRuleArrow_in_ruleRuleStart265 = new BitSet(new long[]{0x0000000000007802L});
        public static final BitSet FOLLOW_ruleRuleSimple_in_entryRuleRuleSimple303 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleSimple313 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleRuleSimple362 = new BitSet(new long[]{0x000000001B0F8010L});
        public static final BitSet FOLLOW_16_in_ruleRuleSimple391 = new BitSet(new long[]{0x000000001B0F8010L});
        public static final BitSet FOLLOW_17_in_ruleRuleSimple420 = new BitSet(new long[]{0x000000001B0F8010L});
        public static final BitSet FOLLOW_18_in_ruleRuleSimple449 = new BitSet(new long[]{0x000000001B0F8010L});
        public static final BitSet FOLLOW_19_in_ruleRuleSimple478 = new BitSet(new long[]{0x000000001B0F8010L});
        public static final BitSet FOLLOW_ruleRuleStart_in_ruleRuleSimple501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleUnaryPropositionalLogic_in_ruleRuleSimple530 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleArrow_in_entryRuleRuleArrow565 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleArrow575 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleDisjunction_in_ruleRuleArrow622 = new BitSet(new long[]{0x0000000000300002L});
        public static final BitSet FOLLOW_20_in_ruleRuleArrow645 = new BitSet(new long[]{0x000000001B0F8010L});
        public static final BitSet FOLLOW_21_in_ruleRuleArrow674 = new BitSet(new long[]{0x000000001B0F8010L});
        public static final BitSet FOLLOW_ruleRuleDisjunction_in_ruleRuleArrow697 = new BitSet(new long[]{0x0000000000300002L});
        public static final BitSet FOLLOW_ruleRuleDisjunction_in_entryRuleRuleDisjunction735 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleDisjunction745 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleConjunction_in_ruleRuleDisjunction792 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_22_in_ruleRuleDisjunction813 = new BitSet(new long[]{0x000000001B0F8010L});
        public static final BitSet FOLLOW_ruleRuleConjunction_in_ruleRuleDisjunction834 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_ruleRuleConjunction_in_entryRuleRuleConjunction872 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleConjunction882 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleSimple_in_ruleRuleConjunction929 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_23_in_ruleRuleConjunction950 = new BitSet(new long[]{0x000000001B0F8010L});
        public static final BitSet FOLLOW_ruleRuleSimple_in_ruleRuleConjunction971 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_ruleRuleUnaryPropositionalLogic_in_entryRuleRuleUnaryPropositionalLogic1009 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleUnaryPropositionalLogic1019 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleRuleUnaryPropositionalLogic1066 = new BitSet(new long[]{0x000000001B0F8010L});
        public static final BitSet FOLLOW_ruleRuleStart_in_ruleRuleUnaryPropositionalLogic1087 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleAtomic_in_ruleRuleUnaryPropositionalLogic1116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleAtomic_in_entryRuleRuleAtomic1151 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleAtomic1161 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleRuleAtomic1199 = new BitSet(new long[]{0x000000001B0F8010L});
        public static final BitSet FOLLOW_ruleRuleStart_in_ruleRuleAtomic1221 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleRuleAtomic1232 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleAtomic1266 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleRuleAtomic1300 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleRuleAtomic1329 = new BitSet(new long[]{0x0000000000000002L});
    }


}