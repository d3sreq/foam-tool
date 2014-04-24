package transformation.propositionallogiclang2propositionallogic.parser.antlr.internal; 

import org.antlr.runtime.BitSet;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;

import transformation.propositionallogiclang2propositionallogic.services.PropositionalLogicXtextGrammarAccess;

@SuppressWarnings("all")
public class InternalPropositionalLogicXtextParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'->'", "'<->'", "'|'", "'&'", "'!'", "'('", "')'", "'true'", "'false'"
    };
    public static final int T__19=19;
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalPropositionalLogicXtextParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPropositionalLogicXtextParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPropositionalLogicXtextParser.tokenNames; }
    public String getGrammarFileName() { return "../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g"; }



     	private PropositionalLogicXtextGrammarAccess grammarAccess;
     	
        public InternalPropositionalLogicXtextParser(TokenStream input, PropositionalLogicXtextGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "RuleStart";	
       	}
       	
       	@Override
       	protected PropositionalLogicXtextGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleRuleStart"
    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:67:1: entryRuleRuleStart returns [EObject current=null] : iv_ruleRuleStart= ruleRuleStart EOF ;
    public final EObject entryRuleRuleStart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleStart = null;


        try {
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:68:2: (iv_ruleRuleStart= ruleRuleStart EOF )
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:69:2: iv_ruleRuleStart= ruleRuleStart EOF
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
    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:76:1: ruleRuleStart returns [EObject current=null] : this_RuleArrow_0= ruleRuleArrow ;
    public final EObject ruleRuleStart() throws RecognitionException {
        EObject current = null;

        EObject this_RuleArrow_0 = null;


         enterRule(); 
            
        try {
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:79:28: (this_RuleArrow_0= ruleRuleArrow )
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:81:5: this_RuleArrow_0= ruleRuleArrow
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


    // $ANTLR start "entryRuleRuleArrow"
    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:97:1: entryRuleRuleArrow returns [EObject current=null] : iv_ruleRuleArrow= ruleRuleArrow EOF ;
    public final EObject entryRuleRuleArrow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleArrow = null;


        try {
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:98:2: (iv_ruleRuleArrow= ruleRuleArrow EOF )
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:99:2: iv_ruleRuleArrow= ruleRuleArrow EOF
            {
             newCompositeNode(grammarAccess.getRuleArrowRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleArrow_in_entryRuleRuleArrow165);
            iv_ruleRuleArrow=ruleRuleArrow();

            state._fsp--;

             current =iv_ruleRuleArrow; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleArrow175); 

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
    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:106:1: ruleRuleArrow returns [EObject current=null] : (this_RuleDisjunction_0= ruleRuleDisjunction ( ( ( () otherlv_2= '->' ) | ( () otherlv_4= '<->' ) ) ( (lv_right_5_0= ruleRuleDisjunction ) ) )* ) ;
    public final EObject ruleRuleArrow() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_RuleDisjunction_0 = null;

        EObject lv_right_5_0 = null;


         enterRule(); 
            
        try {
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:109:28: ( (this_RuleDisjunction_0= ruleRuleDisjunction ( ( ( () otherlv_2= '->' ) | ( () otherlv_4= '<->' ) ) ( (lv_right_5_0= ruleRuleDisjunction ) ) )* ) )
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:110:1: (this_RuleDisjunction_0= ruleRuleDisjunction ( ( ( () otherlv_2= '->' ) | ( () otherlv_4= '<->' ) ) ( (lv_right_5_0= ruleRuleDisjunction ) ) )* )
            {
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:110:1: (this_RuleDisjunction_0= ruleRuleDisjunction ( ( ( () otherlv_2= '->' ) | ( () otherlv_4= '<->' ) ) ( (lv_right_5_0= ruleRuleDisjunction ) ) )* )
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:111:5: this_RuleDisjunction_0= ruleRuleDisjunction ( ( ( () otherlv_2= '->' ) | ( () otherlv_4= '<->' ) ) ( (lv_right_5_0= ruleRuleDisjunction ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getRuleArrowAccess().getRuleDisjunctionParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleRuleDisjunction_in_ruleRuleArrow222);
            this_RuleDisjunction_0=ruleRuleDisjunction();

            state._fsp--;

             
                    current = this_RuleDisjunction_0; 
                    afterParserOrEnumRuleCall();
                
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:119:1: ( ( ( () otherlv_2= '->' ) | ( () otherlv_4= '<->' ) ) ( (lv_right_5_0= ruleRuleDisjunction ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }
                else if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:119:2: ( ( () otherlv_2= '->' ) | ( () otherlv_4= '<->' ) ) ( (lv_right_5_0= ruleRuleDisjunction ) )
            	    {
            	    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:119:2: ( ( () otherlv_2= '->' ) | ( () otherlv_4= '<->' ) )
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==11) ) {
            	        alt1=1;
            	    }
            	    else if ( (LA1_0==12) ) {
            	        alt1=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 1, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:119:3: ( () otherlv_2= '->' )
            	            {
            	            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:119:3: ( () otherlv_2= '->' )
            	            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:119:4: () otherlv_2= '->'
            	            {
            	            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:119:4: ()
            	            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:120:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getRuleArrowAccess().getImplicationLeftAction_1_0_0_0(),
            	                        current);
            	                

            	            }

            	            otherlv_2=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleRuleArrow245); 

            	                	newLeafNode(otherlv_2, grammarAccess.getRuleArrowAccess().getHyphenMinusGreaterThanSignKeyword_1_0_0_1());
            	                

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:130:6: ( () otherlv_4= '<->' )
            	            {
            	            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:130:6: ( () otherlv_4= '<->' )
            	            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:130:7: () otherlv_4= '<->'
            	            {
            	            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:130:7: ()
            	            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:131:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getRuleArrowAccess().getEquivalenceLeftAction_1_0_1_0(),
            	                        current);
            	                

            	            }

            	            otherlv_4=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleRuleArrow274); 

            	                	newLeafNode(otherlv_4, grammarAccess.getRuleArrowAccess().getLessThanSignHyphenMinusGreaterThanSignKeyword_1_0_1_1());
            	                

            	            }


            	            }
            	            break;

            	    }

            	    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:140:3: ( (lv_right_5_0= ruleRuleDisjunction ) )
            	    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:141:1: (lv_right_5_0= ruleRuleDisjunction )
            	    {
            	    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:141:1: (lv_right_5_0= ruleRuleDisjunction )
            	    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:142:3: lv_right_5_0= ruleRuleDisjunction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRuleArrowAccess().getRightRuleDisjunctionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleRuleDisjunction_in_ruleRuleArrow297);
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
    // $ANTLR end "ruleRuleArrow"


    // $ANTLR start "entryRuleRuleDisjunction"
    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:166:1: entryRuleRuleDisjunction returns [EObject current=null] : iv_ruleRuleDisjunction= ruleRuleDisjunction EOF ;
    public final EObject entryRuleRuleDisjunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleDisjunction = null;


        try {
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:167:2: (iv_ruleRuleDisjunction= ruleRuleDisjunction EOF )
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:168:2: iv_ruleRuleDisjunction= ruleRuleDisjunction EOF
            {
             newCompositeNode(grammarAccess.getRuleDisjunctionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleDisjunction_in_entryRuleRuleDisjunction335);
            iv_ruleRuleDisjunction=ruleRuleDisjunction();

            state._fsp--;

             current =iv_ruleRuleDisjunction; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleDisjunction345); 

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
    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:175:1: ruleRuleDisjunction returns [EObject current=null] : (this_RuleConjunction_0= ruleRuleConjunction ( () otherlv_2= '|' ( (lv_right_3_0= ruleRuleConjunction ) ) )* ) ;
    public final EObject ruleRuleDisjunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_RuleConjunction_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:178:28: ( (this_RuleConjunction_0= ruleRuleConjunction ( () otherlv_2= '|' ( (lv_right_3_0= ruleRuleConjunction ) ) )* ) )
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:179:1: (this_RuleConjunction_0= ruleRuleConjunction ( () otherlv_2= '|' ( (lv_right_3_0= ruleRuleConjunction ) ) )* )
            {
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:179:1: (this_RuleConjunction_0= ruleRuleConjunction ( () otherlv_2= '|' ( (lv_right_3_0= ruleRuleConjunction ) ) )* )
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:180:5: this_RuleConjunction_0= ruleRuleConjunction ( () otherlv_2= '|' ( (lv_right_3_0= ruleRuleConjunction ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getRuleDisjunctionAccess().getRuleConjunctionParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleRuleConjunction_in_ruleRuleDisjunction392);
            this_RuleConjunction_0=ruleRuleConjunction();

            state._fsp--;

             
                    current = this_RuleConjunction_0; 
                    afterParserOrEnumRuleCall();
                
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:188:1: ( () otherlv_2= '|' ( (lv_right_3_0= ruleRuleConjunction ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:188:2: () otherlv_2= '|' ( (lv_right_3_0= ruleRuleConjunction ) )
            	    {
            	    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:188:2: ()
            	    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:189:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getRuleDisjunctionAccess().getOrLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleRuleDisjunction413); 

            	        	newLeafNode(otherlv_2, grammarAccess.getRuleDisjunctionAccess().getVerticalLineKeyword_1_1());
            	        
            	    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:198:1: ( (lv_right_3_0= ruleRuleConjunction ) )
            	    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:199:1: (lv_right_3_0= ruleRuleConjunction )
            	    {
            	    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:199:1: (lv_right_3_0= ruleRuleConjunction )
            	    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:200:3: lv_right_3_0= ruleRuleConjunction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRuleDisjunctionAccess().getRightRuleConjunctionParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleRuleConjunction_in_ruleRuleDisjunction434);
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
            	    break loop3;
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
    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:224:1: entryRuleRuleConjunction returns [EObject current=null] : iv_ruleRuleConjunction= ruleRuleConjunction EOF ;
    public final EObject entryRuleRuleConjunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleConjunction = null;


        try {
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:225:2: (iv_ruleRuleConjunction= ruleRuleConjunction EOF )
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:226:2: iv_ruleRuleConjunction= ruleRuleConjunction EOF
            {
             newCompositeNode(grammarAccess.getRuleConjunctionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleConjunction_in_entryRuleRuleConjunction472);
            iv_ruleRuleConjunction=ruleRuleConjunction();

            state._fsp--;

             current =iv_ruleRuleConjunction; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleConjunction482); 

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
    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:233:1: ruleRuleConjunction returns [EObject current=null] : (this_RuleSimple_0= ruleRuleSimple ( () otherlv_2= '&' ( (lv_right_3_0= ruleRuleSimple ) ) )* ) ;
    public final EObject ruleRuleConjunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_RuleSimple_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:236:28: ( (this_RuleSimple_0= ruleRuleSimple ( () otherlv_2= '&' ( (lv_right_3_0= ruleRuleSimple ) ) )* ) )
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:237:1: (this_RuleSimple_0= ruleRuleSimple ( () otherlv_2= '&' ( (lv_right_3_0= ruleRuleSimple ) ) )* )
            {
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:237:1: (this_RuleSimple_0= ruleRuleSimple ( () otherlv_2= '&' ( (lv_right_3_0= ruleRuleSimple ) ) )* )
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:238:5: this_RuleSimple_0= ruleRuleSimple ( () otherlv_2= '&' ( (lv_right_3_0= ruleRuleSimple ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getRuleConjunctionAccess().getRuleSimpleParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleRuleSimple_in_ruleRuleConjunction529);
            this_RuleSimple_0=ruleRuleSimple();

            state._fsp--;

             
                    current = this_RuleSimple_0; 
                    afterParserOrEnumRuleCall();
                
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:246:1: ( () otherlv_2= '&' ( (lv_right_3_0= ruleRuleSimple ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:246:2: () otherlv_2= '&' ( (lv_right_3_0= ruleRuleSimple ) )
            	    {
            	    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:246:2: ()
            	    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:247:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getRuleConjunctionAccess().getAndLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleRuleConjunction550); 

            	        	newLeafNode(otherlv_2, grammarAccess.getRuleConjunctionAccess().getAmpersandKeyword_1_1());
            	        
            	    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:256:1: ( (lv_right_3_0= ruleRuleSimple ) )
            	    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:257:1: (lv_right_3_0= ruleRuleSimple )
            	    {
            	    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:257:1: (lv_right_3_0= ruleRuleSimple )
            	    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:258:3: lv_right_3_0= ruleRuleSimple
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRuleConjunctionAccess().getRightRuleSimpleParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleRuleSimple_in_ruleRuleConjunction571);
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
            	    break loop4;
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


    // $ANTLR start "entryRuleRuleSimple"
    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:282:1: entryRuleRuleSimple returns [EObject current=null] : iv_ruleRuleSimple= ruleRuleSimple EOF ;
    public final EObject entryRuleRuleSimple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleSimple = null;


        try {
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:283:2: (iv_ruleRuleSimple= ruleRuleSimple EOF )
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:284:2: iv_ruleRuleSimple= ruleRuleSimple EOF
            {
             newCompositeNode(grammarAccess.getRuleSimpleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleSimple_in_entryRuleRuleSimple609);
            iv_ruleRuleSimple=ruleRuleSimple();

            state._fsp--;

             current =iv_ruleRuleSimple; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleSimple619); 

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
    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:291:1: ruleRuleSimple returns [EObject current=null] : this_RuleUnaryPropositionalLogic_0= ruleRuleUnaryPropositionalLogic ;
    public final EObject ruleRuleSimple() throws RecognitionException {
        EObject current = null;

        EObject this_RuleUnaryPropositionalLogic_0 = null;


         enterRule(); 
            
        try {
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:294:28: (this_RuleUnaryPropositionalLogic_0= ruleRuleUnaryPropositionalLogic )
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:296:5: this_RuleUnaryPropositionalLogic_0= ruleRuleUnaryPropositionalLogic
            {
             
                    newCompositeNode(grammarAccess.getRuleSimpleAccess().getRuleUnaryPropositionalLogicParserRuleCall()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleRuleUnaryPropositionalLogic_in_ruleRuleSimple665);
            this_RuleUnaryPropositionalLogic_0=ruleRuleUnaryPropositionalLogic();

            state._fsp--;

             
                    current = this_RuleUnaryPropositionalLogic_0; 
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
    // $ANTLR end "ruleRuleSimple"


    // $ANTLR start "entryRuleRuleUnaryPropositionalLogic"
    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:312:1: entryRuleRuleUnaryPropositionalLogic returns [EObject current=null] : iv_ruleRuleUnaryPropositionalLogic= ruleRuleUnaryPropositionalLogic EOF ;
    public final EObject entryRuleRuleUnaryPropositionalLogic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleUnaryPropositionalLogic = null;


        try {
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:313:2: (iv_ruleRuleUnaryPropositionalLogic= ruleRuleUnaryPropositionalLogic EOF )
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:314:2: iv_ruleRuleUnaryPropositionalLogic= ruleRuleUnaryPropositionalLogic EOF
            {
             newCompositeNode(grammarAccess.getRuleUnaryPropositionalLogicRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleUnaryPropositionalLogic_in_entryRuleRuleUnaryPropositionalLogic699);
            iv_ruleRuleUnaryPropositionalLogic=ruleRuleUnaryPropositionalLogic();

            state._fsp--;

             current =iv_ruleRuleUnaryPropositionalLogic; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleUnaryPropositionalLogic709); 

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
    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:321:1: ruleRuleUnaryPropositionalLogic returns [EObject current=null] : ( ( () otherlv_1= '!' ( (lv_formula_2_0= ruleRuleStart ) ) ) | this_RuleAtomic_3= ruleRuleAtomic ) ;
    public final EObject ruleRuleUnaryPropositionalLogic() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_formula_2_0 = null;

        EObject this_RuleAtomic_3 = null;


         enterRule(); 
            
        try {
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:324:28: ( ( ( () otherlv_1= '!' ( (lv_formula_2_0= ruleRuleStart ) ) ) | this_RuleAtomic_3= ruleRuleAtomic ) )
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:325:1: ( ( () otherlv_1= '!' ( (lv_formula_2_0= ruleRuleStart ) ) ) | this_RuleAtomic_3= ruleRuleAtomic )
            {
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:325:1: ( ( () otherlv_1= '!' ( (lv_formula_2_0= ruleRuleStart ) ) ) | this_RuleAtomic_3= ruleRuleAtomic )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_ID||LA5_0==16||(LA5_0>=18 && LA5_0<=19)) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:325:2: ( () otherlv_1= '!' ( (lv_formula_2_0= ruleRuleStart ) ) )
                    {
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:325:2: ( () otherlv_1= '!' ( (lv_formula_2_0= ruleRuleStart ) ) )
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:325:3: () otherlv_1= '!' ( (lv_formula_2_0= ruleRuleStart ) )
                    {
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:325:3: ()
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:326:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getRuleUnaryPropositionalLogicAccess().getNotAction_0_0(),
                                current);
                        

                    }

                    otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleRuleUnaryPropositionalLogic756); 

                        	newLeafNode(otherlv_1, grammarAccess.getRuleUnaryPropositionalLogicAccess().getExclamationMarkKeyword_0_1());
                        
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:335:1: ( (lv_formula_2_0= ruleRuleStart ) )
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:336:1: (lv_formula_2_0= ruleRuleStart )
                    {
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:336:1: (lv_formula_2_0= ruleRuleStart )
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:337:3: lv_formula_2_0= ruleRuleStart
                    {
                     
                    	        newCompositeNode(grammarAccess.getRuleUnaryPropositionalLogicAccess().getFormulaRuleStartParserRuleCall_0_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleRuleStart_in_ruleRuleUnaryPropositionalLogic777);
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
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:355:5: this_RuleAtomic_3= ruleRuleAtomic
                    {
                     
                            newCompositeNode(grammarAccess.getRuleUnaryPropositionalLogicAccess().getRuleAtomicParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRuleAtomic_in_ruleRuleUnaryPropositionalLogic806);
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
    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:371:1: entryRuleRuleAtomic returns [EObject current=null] : iv_ruleRuleAtomic= ruleRuleAtomic EOF ;
    public final EObject entryRuleRuleAtomic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleAtomic = null;


        try {
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:372:2: (iv_ruleRuleAtomic= ruleRuleAtomic EOF )
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:373:2: iv_ruleRuleAtomic= ruleRuleAtomic EOF
            {
             newCompositeNode(grammarAccess.getRuleAtomicRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleAtomic_in_entryRuleRuleAtomic841);
            iv_ruleRuleAtomic=ruleRuleAtomic();

            state._fsp--;

             current =iv_ruleRuleAtomic; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleAtomic851); 

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
    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:380:1: ruleRuleAtomic returns [EObject current=null] : ( (otherlv_0= '(' this_RuleStart_1= ruleRuleStart otherlv_2= ')' ) | ( () ( (lv_variable_4_0= RULE_ID ) ) ) | ( () otherlv_6= 'true' ) | ( () otherlv_8= 'false' ) ) ;
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
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:383:28: ( ( (otherlv_0= '(' this_RuleStart_1= ruleRuleStart otherlv_2= ')' ) | ( () ( (lv_variable_4_0= RULE_ID ) ) ) | ( () otherlv_6= 'true' ) | ( () otherlv_8= 'false' ) ) )
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:384:1: ( (otherlv_0= '(' this_RuleStart_1= ruleRuleStart otherlv_2= ')' ) | ( () ( (lv_variable_4_0= RULE_ID ) ) ) | ( () otherlv_6= 'true' ) | ( () otherlv_8= 'false' ) )
            {
            // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:384:1: ( (otherlv_0= '(' this_RuleStart_1= ruleRuleStart otherlv_2= ')' ) | ( () ( (lv_variable_4_0= RULE_ID ) ) ) | ( () otherlv_6= 'true' ) | ( () otherlv_8= 'false' ) )
            int alt6=4;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt6=1;
                }
                break;
            case RULE_ID:
                {
                alt6=2;
                }
                break;
            case 18:
                {
                alt6=3;
                }
                break;
            case 19:
                {
                alt6=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:384:2: (otherlv_0= '(' this_RuleStart_1= ruleRuleStart otherlv_2= ')' )
                    {
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:384:2: (otherlv_0= '(' this_RuleStart_1= ruleRuleStart otherlv_2= ')' )
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:384:4: otherlv_0= '(' this_RuleStart_1= ruleRuleStart otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleRuleAtomic889); 

                        	newLeafNode(otherlv_0, grammarAccess.getRuleAtomicAccess().getLeftParenthesisKeyword_0_0());
                        
                     
                            newCompositeNode(grammarAccess.getRuleAtomicAccess().getRuleStartParserRuleCall_0_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRuleStart_in_ruleRuleAtomic911);
                    this_RuleStart_1=ruleRuleStart();

                    state._fsp--;

                     
                            current = this_RuleStart_1; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleRuleAtomic922); 

                        	newLeafNode(otherlv_2, grammarAccess.getRuleAtomicAccess().getRightParenthesisKeyword_0_2());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:402:6: ( () ( (lv_variable_4_0= RULE_ID ) ) )
                    {
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:402:6: ( () ( (lv_variable_4_0= RULE_ID ) ) )
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:402:7: () ( (lv_variable_4_0= RULE_ID ) )
                    {
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:402:7: ()
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:403:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getRuleAtomicAccess().getRuleVariableUseAction_1_0(),
                                current);
                        

                    }

                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:408:2: ( (lv_variable_4_0= RULE_ID ) )
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:409:1: (lv_variable_4_0= RULE_ID )
                    {
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:409:1: (lv_variable_4_0= RULE_ID )
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:410:3: lv_variable_4_0= RULE_ID
                    {
                    lv_variable_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleAtomic956); 

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
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:427:6: ( () otherlv_6= 'true' )
                    {
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:427:6: ( () otherlv_6= 'true' )
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:427:7: () otherlv_6= 'true'
                    {
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:427:7: ()
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:428:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getRuleAtomicAccess().getTrueAction_2_0(),
                                current);
                        

                    }

                    otherlv_6=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleRuleAtomic990); 

                        	newLeafNode(otherlv_6, grammarAccess.getRuleAtomicAccess().getTrueKeyword_2_1());
                        

                    }


                    }
                    break;
                case 4 :
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:438:6: ( () otherlv_8= 'false' )
                    {
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:438:6: ( () otherlv_8= 'false' )
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:438:7: () otherlv_8= 'false'
                    {
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:438:7: ()
                    // ../transformation.propositionallogiclang2propositionallogic/src-gen/propositionallogiclang2propositionallogic/parser/antlr/internal/InternalPropositionalLogicXtext.g:439:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getRuleAtomicAccess().getFalseAction_3_0(),
                                current);
                        

                    }

                    otherlv_8=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleRuleAtomic1019); 

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
        public static final BitSet FOLLOW_ruleRuleArrow_in_entryRuleRuleArrow165 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleArrow175 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleDisjunction_in_ruleRuleArrow222 = new BitSet(new long[]{0x0000000000001802L});
        public static final BitSet FOLLOW_11_in_ruleRuleArrow245 = new BitSet(new long[]{0x00000000000D8010L});
        public static final BitSet FOLLOW_12_in_ruleRuleArrow274 = new BitSet(new long[]{0x00000000000D8010L});
        public static final BitSet FOLLOW_ruleRuleDisjunction_in_ruleRuleArrow297 = new BitSet(new long[]{0x0000000000001802L});
        public static final BitSet FOLLOW_ruleRuleDisjunction_in_entryRuleRuleDisjunction335 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleDisjunction345 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleConjunction_in_ruleRuleDisjunction392 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleRuleDisjunction413 = new BitSet(new long[]{0x00000000000D8010L});
        public static final BitSet FOLLOW_ruleRuleConjunction_in_ruleRuleDisjunction434 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_ruleRuleConjunction_in_entryRuleRuleConjunction472 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleConjunction482 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleSimple_in_ruleRuleConjunction529 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_14_in_ruleRuleConjunction550 = new BitSet(new long[]{0x00000000000D8010L});
        public static final BitSet FOLLOW_ruleRuleSimple_in_ruleRuleConjunction571 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_ruleRuleSimple_in_entryRuleRuleSimple609 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleSimple619 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleUnaryPropositionalLogic_in_ruleRuleSimple665 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleUnaryPropositionalLogic_in_entryRuleRuleUnaryPropositionalLogic699 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleUnaryPropositionalLogic709 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleRuleUnaryPropositionalLogic756 = new BitSet(new long[]{0x00000000000D8010L});
        public static final BitSet FOLLOW_ruleRuleStart_in_ruleRuleUnaryPropositionalLogic777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleAtomic_in_ruleRuleUnaryPropositionalLogic806 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleAtomic_in_entryRuleRuleAtomic841 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleAtomic851 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleRuleAtomic889 = new BitSet(new long[]{0x00000000000D8010L});
        public static final BitSet FOLLOW_ruleRuleStart_in_ruleRuleAtomic911 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleRuleAtomic922 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleAtomic956 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleRuleAtomic990 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleRuleAtomic1019 = new BitSet(new long[]{0x0000000000000002L});
    }


}