package parser.syntactic;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTextArea;

import parser.contents.*;
import parser.elements.*;
import parser.errors.*;
import parser.lexical.Lexical;
import view.Interface;


public class SyntacticAnalizer {

	/**
	 * @uml.property  name="token_act"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Token token_act;
	/**
	 * @uml.property  name="lexicalAnalyzer"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Lexical lexicalAnalyzer;
	/**
	 * @uml.property  name="hayTipo"
	 */
	boolean hayTipo = false;
	/**
	 * @uml.property  name="hayComa"
	 */
	boolean hayComa = false;
	/**
	 * @uml.property  name="existError"
	 */
	boolean existError = false;
	/**
	 * @uml.property  name="transit"
	 */
	boolean transit = false;
	//private JTextArea console= new JTextArea();
	/**
	 * @uml.property  name="console"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextArea console;
	/**
	 * @uml.property  name="errors"
	 * @uml.associationEnd  
	 */
	private Errors errors;
	/**
	 * @uml.property  name="statement"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="parser.contents.Binding"
	 */
	private ArrayList<Statement> statement;
	/**
	 * @uml.property  name="row"
	 * @uml.associationEnd  qualifier="var:parser.elements.Variable parser.elements.Value"
	 */
	private Vector<Variable> row;


	/**
	 * @uml.property  name="program"
	 * @uml.associationEnd  
	 */
	private Program program;

	/**
	 * @uml.property  name="e"
	 * @uml.associationEnd  
	 */
	private Expression e;
	/**
	 * @uml.property  name="i"
	 * @uml.associationEnd  readOnly="true"
	 */
	private Interface i;

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}
	public Vector<Variable> getRow() {
		return row;
	}

	public void setRow(Vector<Variable> row) {
		this.row = row;
	}



	/**
	 * constructor of the class
	 * 
	 * @param lexicalAnalyzer 
	 * Tokens provides language processing.
	 */
	public SyntacticAnalizer(Lexical lexicalAnalyzer, JTextArea console) {
		this.lexicalAnalyzer = lexicalAnalyzer;
		token_act = lexicalAnalyzer.sigToken();
		statement = new ArrayList<Statement>();
		//row = new HashMap<Variable,Value>();
		this.console= console;
	}

	/**
	 * Mehod that returns console content
	 * @return  returns console content
	 * @uml.property  name="console"
	 */
	public JTextArea getConsole(){
		return console;
	}




	/**
	 * Method that checks if the attribute is null Token.
	 * 
	 * @return
	 * returns true if the attribute is null token, if 
	 * otherwise it returns false.
	 * 	
	 */
	private boolean atributeNull() {
		return (token_act.readAtribute() == null);
	}

	/**
	 * Method that checks Token type.   
	 * 
	 * @param s 
	 * in param, gives the searched type.
	 * 
	 * @return 
	 * if it's the type searched, returns true and advances to next token
	 * returns false otherwise
	 */
	private boolean checkTokenType(String s) {
		boolean check = false;
		if (token_act.leeTipo().compareTo(s) == 0) {
			System.out.println(token_act.toString() + " ");
			token_act = lexicalAnalyzer.sigToken();
			check = true;
		}
		return check;
	}

	/**
	 * Method that checks Token type.  
	 * 
	 * @param s 
	 * in param, gives the searched type.
	 * 
	 * @return 
	 * if it's the type searched, returns true
	 * returns false otherwise
	 * (Without advancing token)
	 */
	private boolean checkTypeWithoutAdvancing(String s) {
		boolean check = false;

		if (token_act.leeTipo().compareTo(s) == 0) {
			System.out.println(token_act.toString() + " ");
			check = true;
		}
		return check;
	}

	/**
	 * Method that checks Token attribute.
	 * 
	 * @param s
	 * input parameter, which gives the attribute you want.
	 * 
	 * @return 
	 * returns true if this token and advances have the same attribute expected,
	 * otherwise returns false.
	 */
	private boolean checkAtribute(String s) {
		Token tok = token_act;
		if (!atributeNull()	&& tok.readAtribute().equals(s)) {
			System.out.println(token_act.toString() + " ");
			token_act = lexicalAnalyzer.sigToken();
			return true;
		}

		return false;
	}

	/**
	 * Method that checks the attribute Token.
	 *
	 * @param s
	 * input parameter, which gives the attribute you want.
	 * 
	 * @return
	 * returns true if the token has the same attribute 
     * the expected, otherwise returns false.
	 */
	@SuppressWarnings("unused")
	private boolean compruebaAtributoNoAvanzado(Object s) {
		Token tok = token_act;
		if (!atributeNull()	&& tok.readAtribute().equals(s)) {
			System.out.println(token_act.toString() + " ");
			return true;
		}
		return false;
	}


	/**
	 * 
	 * @param error
	 */
	public void setError(Errors errors) {
		this.errors = errors;
	}

	/**
	 * Method that evaluates the following grammar rules:
	 * 
	 * - R1: program → (statement ';' )*
	 * - R2: statement → filter | binding
	 * - R3: binding→ id ':=' Exp0
	 * - R4: filter → '#' Exp0
	 * 
	 * 
	 * @param throwError
	 * 
	 * 
	 * @return
	 */
	public void program(boolean throwError) {
		boolean correct = false;
		boolean sentenceDeclared = false;
		Token tok = token_act;

		System.out.println("***Principal***");

		if (checkAtribute("#")) {//Begin filter
			/*	if (checkTokenType("identificator")) {//Begin assignment
				sentenceDeclared = true;	
				if (checkTypeWithoutAdvancing(":=")) {
					String s =  tok.readAtribute();
					Expression_Boolean result = assignment();
					if(!existError){
						correct = result.isCorrect();
						e = result.getExpression();

						Binding b = new Binding(e,s);					
						statement.add(b);
					}

				}else{
					setError(new Errors(3,tok,throwError,console));
					existError=true;
				}


			} else if (!existError && throwError) {
				setError(new Errors(1,tok,throwError,console));
				existError=true;
			}
			else{*/
			sentenceDeclared = true;
			System.out.println("***#Filter***");
			Expression_Boolean result = exp0(true);
			correct = result.isCorrect();
			if (!correct){
				setError(new Errors(2,tok,throwError,console));
				existError=true;
			}else{

				Filter f = new Filter(e);
				statement.add(f);
			}
			//	}
		} else if (checkTokenType("identificator")) {//Begin assignment
			sentenceDeclared = true;	
			if (checkTypeWithoutAdvancing(":=")) {
				String s =  tok.readAtribute();
				Expression_Boolean result = assignment();
				if(!existError){
					correct = result.isCorrect();
					e = result.getExpression();
					/*Value val = e.getValue(row);
					Variable var = new Variable(s,val);
					row.put(var, val);*/
					Binding b = new Binding(e,s);					
					statement.add(b);
				}

			}else{
				setError(new Errors(3,tok,throwError,console));
				existError=true;
			}


		} else if (!existError && throwError) {
			setError(new Errors(1,tok,throwError,console));
			existError=true;
		}
		if (sentenceDeclared){
			if (!checkAtribute(";")){//Sentence expects ;
				if (!existError && true) {
					setError(new Errors(4,tok,throwError,console));
					existError=true;
				}
			}else{
				program(false);
			}
		}



	}
	public void parser(){
		program(false);
		program = new Program(statement);
		if (!existError) {
			console.setForeground(Color.blue);
			console.append("Correct lexical and syntactic analysis.");			

		}
	}

	/**
	 * 
	 * @param
	 * 
	 * @return
	 * identified returns Expression_Boolean if one of the above rules.
	 */
	private Expression_Boolean assignment( ) {
		boolean correct = false;
		if (!existError) {
			System.out.println("***Asig***");
			if (checkTokenType(":=")) {
				Expression_Boolean result = exp0(true);
				correct = result.isCorrect();
				e = result.getExpression();
			}
			if(!correct){
				if (!existError) {
					setError(new Errors(49,token_act,true,console));//antes error3
					existError=true;
				}
			}
		}
		return new Expression_Boolean(e, correct);
	}





	/**
	 * Method that evaluates the following grammar rules:
	 * 
	 * - R44: IFExpr→ 'if' Exp0 'then'  Exp0 'else' Exp0
	 * 
	 * @ param 
	 * 
	 * @return Expression_Boolean
	 */

	private Expression_Boolean ifExpr() {
		boolean correct = false;
		if (!existError) {
			System.out.println("***IfExpr***");
			if (checkAtribute("if")){
				Expression_Boolean result1 = exp0(true);
				correct = result1.isCorrect();
				if (correct) {	
					Expression e1 = e.deepCopy();
					if (checkAtribute("then")) {//THEN
						System.out.println("THEN read.");	
						Expression_Boolean result2 = exp0(true);
						correct = result2.isCorrect();
						if(correct){
							Expression e2 = e.deepCopy();;
							if (checkAtribute("else")) {				
								System.out.println("ELSE read.");
								Expression_Boolean result3 = exp0(true);
								correct = result3.isCorrect();
								if (correct){
									Expression e3 = e.deepCopy();
									e = new IfExpr(e1,e2,e3);
								}
							}
						}
						/*else if(!existError){
							setError(new Errors(5,token_act,true,console));
							existError =true;
						}

					}else if(!existError){
						setError(new Errors(2,token_act,true,console));
						existError =true;
					}
				} else if(!existError){
					setError(new Errors(6,token_act,true,console));
					existError =true;
				}
			} else if(!existError){
				setError(new Errors(2,token_act,true,console));
				existError =true;
			}*/
					}}}}
		return new Expression_Boolean(e,correct);
	}




	/**
	 * Method that evaluates the following grammar rules:
	 * 
	 *  - R5: Exp0 → exp1
	 *  - R6: Exp0 → exp1 op_log exp1
	 *  
	 *  @ param throwError
	 * 
	 * @return Expression_Boolean
	 */
	private Expression_Boolean exp0(boolean throwError) {
		boolean correct = false;
		Token tok = token_act;
		if (!existError) {
			System.out.println("***Exp0***");
			Expression_Boolean result1 = exp1(throwError);
			correct = result1.isCorrect();
			Token op = token_act;
			if (correct) {
				Expression e1 = e.deepCopy();			
				correct = true;				
				if (opLog()) {
					Expression_Boolean result2 = exp1(true);
					correct = result2.isCorrect();
					if (!correct && !existError){
						setError(new Errors(2,tok,throwError,console));
						existError = true;
					}else{
						Expression e2 = e.deepCopy();
						e = new ExpLog(e1,e2, op.readAtribute());
						/*if(e.getValue(row).getType().equals("error")){
							if(!existError){ 
								int numError = Integer.parseInt(e.getValue(row).getVal());
								setError(new Errors(numError,tok,throwError,console));													
								existError =true;
							}
						}*/

						correct = true;
					}
				}
			}
		}

		return new Expression_Boolean (e,correct);
	}

	/*private Expression_Boolean exp8(boolean throwError) {
		Token tok = token_act;
		boolean correct = false;
		if (!existError) {
			System.out.println("***Exp8***");		

			if (checkTypeWithoutAdvancing(":=")) {
				String s =  tok.leeAtributo();
				Expression_Boolean result = assignment();
				if(!existError){
					correct = result.isCorrect();
					e = result.getExpression();
					Value val = e.getValue(row);
					Variable var = new Variable(s,val);
					row.put(var, val);
					Binding b = new Binding(e,s);					
					statement.add(b);
				}

				else{
					setError(new Errors(3,tok,throwError,console));
					existError=true;
				}


			} else if (!existError && throwError) {
				setError(new Errors(1,tok,throwError,console));
				existError=true;
			}}
		return new Expression_Boolean (e,correct);
	}*/

	/**
	 * Method that evaluates the following grammar rules:
	 * 
	 * - R7: exp1 → exp2
	 * - R8: exp1 → exp2 op_eq exp1
	 * 
	 * @param  throwError
	 * 
	 * @return Expression_Boolean
	 */

	private Expression_Boolean exp1(boolean throwError) {
		boolean correct = false;
		Token tok = token_act;
		if (!existError) {
			System.out.println("***exp1***");
			Expression_Boolean result1 = exp2(throwError);
			correct = result1.isCorrect();
			if (correct) {
				Expression e1 = e.deepCopy();
				correct = true;	
				Token op = token_act;
				if (opEq()) {
					Expression_Boolean result2 = exp1(true);
					correct = result2.isCorrect();
					if ((!correct)&&(!existError)){
						setError(new Errors(2,tok,throwError,console));
						existError =true;
					} else {
						Expression e2 = e.deepCopy();
						e = new ExpEq(e1,e2,op.readAtribute());
						/*if(e.getValue(row).getType().equals("error")){
							if(!existError){ 
								int numError = Integer.parseInt(e.getValue(row).getVal());
								setError(new Errors(numError,tok,throwError,console));													
								existError =true;
							}
						}*/

					}
				}
			}
		}
		return new Expression_Boolean(e,correct);
	}


	/**
	 * Method that evaluates the following grammar rules:
	 * 
	 * - R9:  exp2 → exp3
	 * - R10: exp2 → exp3 op_rel exp2
	 * 
	 * @param throwError
	 * 
	 * @return Expression_Boolean
	 */

	private Expression_Boolean exp2(boolean throwError) {
		boolean correct = false;
		Token tok = token_act;		
		if (!existError) {
			System.out.println("***exp2***");
			Expression_Boolean result1 = exp3(throwError);
			correct = result1.isCorrect();
			if (correct) {
				Expression e1 = e.deepCopy();
				correct = true;
				Token op = token_act;
				if (opRel()) {
					Expression_Boolean result2 = exp2(throwError);
					correct = result2.isCorrect();
					if (!correct && !existError){
						setError(new Errors(2,tok,throwError,console));
						existError = true;
					} else{
						Expression e2 = e.deepCopy();
						e = new ExpRel(e1,e2,op.readAtribute());
						/*if(e.getValue(row).getType().equals("error")){
							if(!existError){ 
								int numError = Integer.parseInt(e.getValue(row).getVal());
								setError(new Errors(numError,tok,throwError,console));													
								existError =true;
							}
						}*/

					}
				}

			}
		}
		return new Expression_Boolean(e,correct);
	}

	/**
	 * Method that evaluates the following grammar rules:
	 * 
	 * - R11: Exp3 → Exp4
	 * - R12: Exp3 → dist ‘(’ Exp4 ‘,’ Exp4 ‘,’ Exp4 ‘,’ Exp4 ‘)’
	 * - R13: Exp3 → abs ‘(’ Exp4 ‘)’
	 * - R14: Exp3 → sind ‘(’ Exp4 ‘)’
	 * - R15: Exp3 → cosd ‘(’ Exp4 ‘)’
	 * - R16: Exp3 → sins ‘(’ Exp4 ‘)’
	 * - R17: Exp3 → coss ‘(’ Exp4 ‘)’
	 * - R18: Exp3 → tans ‘(’ Exp4 ‘)’
	 * - R19: Exp3 → tand ‘(’ Exp4 ‘)’
	 * - R20: Exp3 → arcsins ‘(’ Exp4 ‘)’
	 * - R21: Exp3 → arcsind‘(’ Exp4 ‘)’
	 * - R22: Exp3 → arccoss ‘(’ Exp4 ‘)’
	 * - R23: Exp3 → arccosd ‘(’ Exp4 ‘)’
	 * - R24: Exp3 → arctans ‘(’ Exp4 ‘)’
	 * - R25: Exp3 → arctand ‘(’ Exp4 ‘)’
	 * - R26: Exp3 → s2d ‘(’ Exp4 ‘)’
	 * - R27: Exp3 → d2sra‘(’ Exp4 ‘)’
	 * - R28: Exp3 → d2sdec'(' Exp4 ')'

	 * @param throwError
	 * 
	 * @return Expression_Boolean
	 */
	private Expression_Boolean exp3(boolean throwError) {
		boolean correct = false;
		Token tok = token_act;
		if (!existError) {
			System.out.println("***exp3***");
			Expression_Boolean result1 = exp4(throwError);
			correct = result1.isCorrect();
			if (correct) {
				//e = result1.getExpression();
			}else
				if (checkAtribute("dist")){
					Expression e1 = e.deepCopy();
					Expression e2 = e.deepCopy();
					Expression e3= e.deepCopy();
					Expression e4 = e.deepCopy();
					if(checkAtribute("(")){
						result1 = exp4(true);
						boolean correct1 = result1.isCorrect();
						if (correct1) {
							//Expression e1 = e.deepCopy();

							if(checkAtribute(",")){
								//Expression e2 = e.deepCopy();
								Expression_Boolean result2 = exp4(true);
								boolean correct2 = result2.isCorrect();
								if (correct2) {
									//Expression e2 = e.deepCopy();
									if(checkAtribute(",")){
										//Expression e3 = e.deepCopy();
										Expression_Boolean result3 = exp4(true);
										boolean correct3 = result3.isCorrect();
										if (correct3) {
											//Expression e3 = e.deepCopy();
											if(checkAtribute(",")){
												//Expression e4 = e.deepCopy();
												Expression_Boolean result4 = exp4(true);
												boolean correct4 = result4.isCorrect();
												if (correct4) {
													//Expression e4 = e.deepCopy();
													if(checkAtribute(")")){
														correct = true;														
														e = new Distance(e1, e2, e3, e4);
														/*if(e.getValue(row).getType().equals("error")){
															if(!existError){ 
																int numError = Integer.parseInt(e.getValue(row).getVal());
																setError(new Errors(numError,tok,throwError,console));													
																existError =true;
															}
														}*/
													}else{
														if (!existError){
															setError(new Errors(7,tok,throwError,console));
															existError =true;
														}
													}
												}else{
													if (!existError){
														setError(new Errors(9,tok,throwError,console));
														existError =true;
													}
												}
											}else{
												if (!existError){
													setError(new Errors(8,tok,throwError,console));
													existError =true;
												}
											}
										}else{
											if (!existError){
												setError(new Errors(10,tok,throwError,console));
												existError =true;
											}
										}
									}else{
										if (!existError){
											setError(new Errors(8,tok,throwError,console));
											existError =true;
										}
									}
								}else{
									if (!existError){
										setError(new Errors(11,tok,throwError,console));
										existError =true;
									}
								}
							}else{
								if (!existError){
									setError(new Errors(8,tok,throwError,console));
									existError =true;
								}
							}
						}else{
							if (!existError){
								setError(new Errors(12,tok,throwError,console));
								existError =true;
							}
						}
					}
				}else if (checkAtribute("abs")){
					//Expression e1 = e.deepCopy();
					if(checkAtribute("(")){
						result1 = exp4(throwError);
						boolean correct1 = result1.isCorrect();							
						if (correct1) {
							Expression e1 = e.deepCopy();
							if(checkAtribute(")")){
								correct = true;	
								e = new Abs(e1);
								/*if(e.getValue(row).getType().equals("error")){
									if(!existError){ 
										int numError = Integer.parseInt(e.getValue(row).getVal());
										setError(new Errors(numError,tok,throwError,console));													
										existError =true;
									}
								}*/

							}else{
								if (!existError){
									setError(new Errors(7,tok,throwError,console));
									existError =true;
								}
							}
						}else{
							if (!existError){
								setError(new Errors(13,tok,throwError,console));
								existError =true;
							}
						}
					}else{
						if (!existError){
							setError(new Errors(14,token_act,throwError,console));
							existError =true;
						}
					}
				}else if (checkAtribute("sind")){
					//Expression e1 = e.deepCopy();
					if(checkAtribute("(")){		

						result1 = exp4(throwError);
						boolean correct1 = result1.isCorrect();
						if (correct1) {
							Expression e1 = e.deepCopy();
							if(checkAtribute(")")){
								correct = true;
								e = new Sind(e1);
								/*if(e.getValue(row).getType().equals("error")){
									if(!existError){ 
										int numError = Integer.parseInt(e.getValue(row).getVal());
										setError(new Errors(numError,tok,throwError,console));													
										existError =true;
									}
								}*/
							}else{
								if (!existError){
									setError(new Errors(7,tok,throwError,console));
									existError =true;
								}
							}
						}else{
							if (!existError){
								setError(new Errors(15,tok,throwError,console));
								existError =true;
							}
						}
					}else{
						if (!existError){
							setError(new Errors(16,tok,throwError,console));
							existError =true;
						}
					}
				}else if (checkAtribute("cosd")){
					//Expression e1 = e.deepCopy();
					if(checkAtribute("(")){
						result1 = exp4(throwError);
						boolean correct1 = result1.isCorrect();
						if (correct1) {
							Expression e1 = e.deepCopy();
							if(checkAtribute(")")){
								correct = true;
								e = new Cosd(e1);
								/*if(e.getValue(row).getType().equals("error")){
									if(!existError){ 
										int numError = Integer.parseInt(e.getValue(row).getVal());
										setError(new Errors(numError,tok,throwError,console));													
										existError =true;
									}
								}*/
							}else{
								if (!existError){
									setError(new Errors(7,tok,throwError,console));
									existError =true;
								}
							}
						}else{
							if (!existError){
								setError(new Errors(17,tok,throwError,console));
								existError =true;
							}
						}
					}else{
						if (!existError){
							setError(new Errors(18,token_act,throwError,console));
							existError =true;
						}
					}
				}else if (checkAtribute("sins")){
					//Expression e1 = e.deepCopy();
					if(checkAtribute("(")){
						result1 = exp4(throwError);
						boolean correct1 = result1.isCorrect();
						if (correct1) {
							Expression e1 = e.deepCopy();
							if(checkAtribute(")")){
								correct = true;
								e = new Sins(e1);
								/*if(e.getValue(row).getType().equals("error")){
									if(!existError){ 
										int numError = Integer.parseInt(e.getValue(row).getVal());
										setError(new Errors(numError,tok,throwError,console));													
										existError =true;
									}
								}*/
							}else{
								if (!existError){
									setError(new Errors(7,tok,throwError,console));
									existError =true;
								}
							}
						}else{
							if (!existError){
								setError(new Errors(19,tok,throwError,console));
								existError =true;
							}
						}
					}else{
						if (!existError){
							setError(new Errors(20,tok,throwError,console));
							existError =true;
						}
					}
				}else if (checkAtribute("coss")){
					//Expression e1 = e.deepCopy();
					if(checkAtribute("(")){
						result1 = exp4(throwError);
						boolean correct1 = result1.isCorrect();
						if (correct1) {
							Expression e1 = e.deepCopy();
							if(checkAtribute(")")){
								correct = true;
								e = new Coss(e1);
								/*if(e.getValue(row).getType().equals("error")){
									if(!existError){ 
										int numError = Integer.parseInt(e.getValue(row).getVal());
										setError(new Errors(numError,tok,throwError,console));													
										existError =true;
									}
								}*/
							}else{
								if (!existError){
									setError(new Errors(7,tok,throwError,console));
									existError =true;
								}
							}
						}else{
							if (!existError){
								setError(new Errors(21,tok,throwError,console));
								existError =true;
							}
						}
					}else{
						if (!existError){
							setError(new Errors(22,tok,throwError,console));
							existError =true;
						}
					}
				}else if (checkAtribute("tans")){
					//Expression e1 = e.deepCopy();
					if(checkAtribute("(")){
						result1 = exp4(throwError);
						boolean correct1 = result1.isCorrect();
						if (correct1) {
							Expression e1 = e.deepCopy();
							if(checkAtribute(")")){
								correct = true;
								e = new Tans(e1);
								/*if(e.getValue(row).getType().equals("error")){
									if(!existError){ 
										int numError = Integer.parseInt(e.getValue(row).getVal());
										setError(new Errors(numError,tok,throwError,console));													
										existError =true;
									}
								}*/
							}else{
								if (!existError){
									setError(new Errors(7,tok,throwError,console));
									existError =true;
								}
							}
						}else{
							if (!existError){
								setError(new Errors(23,tok,throwError,console));
								existError =true;
							}
						}
					}else{
						if (!existError){
							setError(new Errors(24,token_act,throwError,console));
							existError =true;
						}
					}
				}else if (checkAtribute("tand")){
					//Expression e1 = e.deepCopy();
					if(checkAtribute("(")){
						result1 = exp4(throwError);
						boolean correct1 = result1.isCorrect();
						if (correct1) {
							Expression e1 = e.deepCopy();
							if(checkAtribute(")")){
								correct = true;
								e = new Tand(e1);
								/*if(e.getValue(row).getType().equals("error")){
									if(!existError){ 
										int numError = Integer.parseInt(e.getValue(row).getVal());
										setError(new Errors(numError,tok,throwError,console));													
										existError =true;
									}
								}*/
							}else{
								if (!existError){
									setError(new Errors(7,tok,throwError,console));
									existError =true;
								}
							}
						}else{
							if (!existError){
								setError(new Errors(25,tok,throwError,console));
								existError =true;
							}
						}
					}else{
						if (!existError){
							setError(new Errors(26,tok,throwError,console));
							existError =true;
						}
					}
				}else if (checkAtribute("arcsins")){
					//Expression e1 = e.deepCopy();
					if(checkAtribute("(")){
						result1 = exp4(throwError);
						boolean correct1 = result1.isCorrect();
						if (correct1) {
							Expression e1 = e.deepCopy();
							if(checkAtribute(")")){
								correct = true;
								e = new Arcsins(e1);
								/*if(e.getValue(row).getType().equals("error")){
									if(!existError){ 
										int numError = Integer.parseInt(e.getValue(row).getVal());
										setError(new Errors(numError,tok,throwError,console));													
										existError =true;
									}
								}*/
							}else{
								if (!existError){
									setError(new Errors(7,tok,throwError,console));
									existError =true;
								}
							}
						}else{
							if (!existError){
								setError(new Errors(27,tok,throwError,console));
								existError =true;
							}
						}
					}else{
						if (!existError){
							setError(new Errors(28,tok,throwError,console));
							existError =true;
						}
					}
				}else if (checkAtribute("arcsind")){//arcsind
					//Expression e1 = e.deepCopy();
					if(checkAtribute("(")){
						result1 = exp4(throwError);
						boolean correct1 = result1.isCorrect();
						if (correct1) {
							Expression e1 = e.deepCopy();
							if(checkAtribute(")")){
								correct = true;
								e = new Arcsind(e1);
								/*if(e.getValue(row).getType().equals("error")){
									if(!existError){ 
										int numError = Integer.parseInt(e.getValue(row).getVal());
										setError(new Errors(numError,tok,throwError,console));													
										existError =true;
									}
								}*/
							}else{
								if (!existError){
									setError(new Errors(7,tok,throwError,console));
									existError =true;
								}
							}
						}else{
							if (!existError){
								setError(new Errors(29,tok,throwError,console));
								existError =true;
							}
						}
					}else{
						if (!existError){
							setError(new Errors(30,token_act,throwError,console));
							existError =true;
						}
					}
				}else if (checkAtribute("arccoss")){
					//Expression e1 = e.deepCopy();
					if(checkAtribute("(")){
						result1 = exp4(throwError);
						boolean correct1 = result1.isCorrect();
						if (correct1) {
							Expression e1 = e.deepCopy();
							if(checkAtribute(")")){
								correct = true;
								e = new Arccoss(e1);
								/*if(e.getValue(row).getType().equals("error")){
									if(!existError){ 
										int numError = Integer.parseInt(e.getValue(row).getVal());
										setError(new Errors(numError,tok,throwError,console));													
										existError =true;
									}
								}*/
							}else{
								if (!existError){
									setError(new Errors(7,tok,throwError,console));
									existError =true;
								}
							}
						}else{
							if (!existError){
								setError(new Errors(31,tok,throwError,console));
								existError =true;
							}
						}
					}else{
						if (!existError){
							setError(new Errors(32,tok,throwError,console));
							existError =true;
						}
					}
				}else if (checkAtribute("arccosd")){
					//Expression e1 = e.deepCopy();
					if(checkAtribute("(")){
						result1 = exp4(throwError);
						boolean correct1 = result1.isCorrect();
						if (correct1) {
							Expression e1 = e.deepCopy();
							if(checkAtribute(")")){
								correct = true;
								e = new Arccosd(e1);
								/*if(e.getValue(row).getType().equals("error")){
									if(!existError){ 
										int numError = Integer.parseInt(e.getValue(row).getVal());
										setError(new Errors(numError,tok,throwError,console));													
										existError =true;
									}
								}
							}else{*/
								if (!existError){
									setError(new Errors(7,tok,throwError,console));
									existError =true;
								}
							}
						}else{
							if (!existError){
								setError(new Errors(33,tok,throwError,console));
								existError =true;
							}
						}
					}else{
						if (!existError){
							setError(new Errors(34,tok,throwError,console));
							existError =true;
						}
					}
				}else if (checkAtribute("arctans")){
					//Expression e1 = e.deepCopy();
					if(checkAtribute("(")){
						result1 = exp4(throwError);
						boolean correct1 = result1.isCorrect();
						if (correct1) {
							Expression e1 = e.deepCopy();
							if(checkAtribute(")")){
								correct = true;
								e = new Arctans(e1);
								/*if(e.getValue(row).getType().equals("error")){
									if(!existError){ 
										int numError = Integer.parseInt(e.getValue(row).getVal());
										setError(new Errors(numError,tok,throwError,console));													
										existError =true;
									}
								}*/
							}else{
								if (!existError){
									setError(new Errors(7,tok,throwError,console));
									existError =true;
								}
							}
						}else{
							if (!existError){
								setError(new Errors(35,tok,throwError,console));
								existError =true;
							}
						}
					}else{
						if (!existError){
							setError(new Errors(36,tok,throwError,console));
							existError =true;
						}
					}
				}else if (checkAtribute("arctand")){
					//Expression e1 = e.deepCopy();
					if(checkAtribute("(")){
						result1 = exp4(throwError);
						boolean correct1 = result1.isCorrect();
						if (correct1) {
							Expression e1 = e.deepCopy();
							if(checkAtribute(")")){
								correct = true;
								e = new Arctand(e1);
								/*if(e.getValue(row).getType().equals("error")){
									if(!existError){ 
										int numError = Integer.parseInt(e.getValue(row).getVal());
										setError(new Errors(numError,tok,throwError,console));													
										existError =true;
									}
								}*/
							}else{
								if (!existError){
									setError(new Errors(7,tok,throwError,console));
									existError =true;
								}
							}
						}else{
							if (!existError){
								setError(new Errors(37,tok,throwError,console));
								existError =true;
							}
						}
					}else{
						if (!existError){
							setError(new Errors(38,tok,throwError,console));
							existError =true;
						}
					}
				}else if (checkAtribute("s2d")){
					//Expression e1 = e.deepCopy();
					if(checkAtribute("(")){
						result1 = exp4(throwError);
						boolean correct1 = result1.isCorrect();
						if (correct1) {
							Expression e1 = e.deepCopy();
							if(checkAtribute(")")){
								correct = true;
								e = new SexaToDec(e1);
								/*if(e.getValue(row).getType().equals("error")){
									if(!existError){ 
										int numError = Integer.parseInt(e.getValue(row).getVal());
										setError(new Errors(numError,tok,throwError,console));													
										existError =true;
									}
								}*/
							}else{
								if (!existError){
									setError(new Errors(7,tok,throwError,console));
									existError =true;
								}
							}
						}else{
							if (!existError){
								setError(new Errors(39,tok,throwError,console));
								existError =true;
							}
						}
					}else{
						if (!existError){
							setError(new Errors(40,tok,throwError,console));
							existError =true;
						}
					}
				}else if (checkAtribute("d2sdec")){
					//Expression e1 = e.deepCopy();
					if(checkAtribute("(")){
						result1 = exp4(throwError);
						boolean correct1 = result1.isCorrect();
						if (correct1) {
							Expression e1 = e.deepCopy();
							if(checkAtribute(")")){
								correct = true;
								e = new DecToSexaDecl(e1);
								/*if(e.getValue(row).getType().equals("error")){
									if(!existError){ 
										int numError = Integer.parseInt(e.getValue(row).getVal());
										setError(new Errors(numError,tok,throwError,console));													
										existError =true;
									}
								}*/
							}else{
								if (!existError){
									setError(new Errors(7,tok,throwError,console));
									existError =true;
								}
							}
						}else{
							if (!existError){
								setError(new Errors(41,tok,throwError,console));
								existError =true;
							}
						}
					}else{
						if (!existError){
							setError(new Errors(42,tok,throwError,console));
							existError =true;
						}
					}
				}else if (checkAtribute("d2sra")){
					//Expression e1 = e.deepCopy();
					if(checkAtribute("(")){
						result1 = exp4(throwError);
						boolean correct1 = result1.isCorrect();
						if (correct1) {
							Expression e1 = e.deepCopy();
							if(checkAtribute(")")){
								correct = true;
								e = new DecToSexaRa(e1);
								/*if(e.getValue(row).getType().equals("error")){
									if(!existError){ 
										int numError = Integer.parseInt(e.getValue(row).getVal());
										setError(new Errors(numError,tok,throwError,console));													
										existError =true;
									}
								}*/
							}else{
								if (!existError){
									setError(new Errors(7,tok,throwError,console));
									existError =true;
								}
							}
						}else{
							if (!existError){
								setError(new Errors(43,tok,throwError,console));
								existError =true;
							}
						}
					}else{
						if (!existError){
							setError(new Errors(44,tok,throwError,console));
							existError =true;
						}
					}
				}

		}

		//}
		return new Expression_Boolean(e,correct);
	}

	/**
	 * Method that evaluates the following grammar rules:
	 *  
	 *  - R29: exp4 → exp5
	 *  - R30: exp4 → exp5 op_adit exp4
	 *  
	 * @param throwsError 
	 *  
	 * @return Expression_Boolean
	 */
	private Expression_Boolean exp4(boolean throwError) {
		boolean correct = false;
		Token tok = token_act;
		if (!existError) {
			System.out.println("***exp4***");
			Expression_Boolean result1 = exp5(throwError);
			boolean correct1 = result1.isCorrect();
			if (correct1) {
				Expression e1 = e.deepCopy();		
				correct = true;
				Token op = token_act;
				if (opAdit()) {
					Expression_Boolean result2 = exp4(true);
					boolean correct2 = result2.isCorrect();
					if ((!correct2)&&(!existError)&&(throwError)){
						setError(new Errors(44,tok,throwError,console));
						existError =true;
					} else {
						Expression e2 = e.deepCopy();										
						e = new ExpAdit(e1,e2,op.readAtribute());
						/*if(e.getValue(row).getType().equals("error")){
							if(!existError){ 
								int numError = Integer.parseInt(e.getValue(row).getVal());
								setError(new Errors(numError,tok,throwError,console));													
								existError =true;
							}
						}*/
						correct = true;	
					}
				}
			}
		}
		return new Expression_Boolean(e, correct);
	}


	/**
	 * Method that evaluates the following grammar rules:
	 * 
	 *  - R31: exp5 → exp6
	 *  - R32: exp5 → exp6 op_mult exp5
	 *  
	 * @param throwsError
	 *  
	 * @return Expression_Boolean
	 */
	private Expression_Boolean exp5(boolean throwError) {
		boolean correct = false;
		Token tok = token_act;
		if (!existError) {
			System.out.println("***exp5***");
			Expression_Boolean result1 = exp6(throwError);
			boolean correct1 = result1.isCorrect();
			if (correct1) {
				Expression e1 = e.deepCopy();
				correct = true;
				Token op = token_act;
				if (opMult()) {
					Expression_Boolean result2 = exp5(true);
					boolean correct2 = result2.isCorrect();
					if (!correct2 && !existError && throwError){
						setError(new Errors(46,tok,throwError,console));
						existError =true;
					} else {
						Expression e2 = e.deepCopy();
						correct = true;
						e = new ExpMult(e1,e2,op.readAtribute());
						/*if(e.getValue(row).getType().equals("error")){
							if(!existError){ 
								int numError = Integer.parseInt(e.getValue(row).getVal());
								setError(new Errors(numError,tok,throwError,console));													
								existError =true;
							}
						}*/

					}
				}
			}		

		}
		return new Expression_Boolean(e, correct);
	}


	/**
	 *  Method that evaluates the following grammar rules:
	 * 
	 *  - R33: exp6 → exp7
	 *  - R34: exp6 → exp7 ^ exp6
	 *  
	 * @param throwsError
	 *  
	 * @return Expression_Boolean
	 * 
	 */
	private Expression_Boolean exp6(boolean throwError) {
		boolean correct = false;
		Token tok = token_act;
		if (!existError) {
			System.out.println("***exp6***");
			Expression_Boolean result1 = exp7(throwError);
			boolean correct1 = result1.isCorrect();
			if (correct1) {
				Expression e1 = e.deepCopy();
				correct = true;				
				if (checkAtribute("^")) {
					Expression_Boolean result2 = exp6(throwError);
					boolean correct2 = result2.isCorrect();
					if (!correct2 && !existError){
						setError(new Errors(47,tok,throwError,console));
						existError =true;
					} else{
						Expression e2 = e.deepCopy();
						correct = true;
						e = new ExpExponential(e1,e2);
						/*if(e.getValue(row).getType().equals("error")){
							if(!existError){ 
								int numError = Integer.parseInt(e.getValue(row).getVal());
								setError(new Errors(numError,tok,throwError,console));													
								existError =true;
							}
						}*/
					}	
				}
			}
		}
		return new Expression_Boolean(e, correct);
	}


	/**
	 *  Method that evaluates the following grammar rules:
	 * 
	 * - R35: exp7 → neg exp5
	 * - R36: exp7 → men exp5 
	 * - R37: exp7 → numbers
	 * - R38: exp7 → booleans
	 * - R39: exp7 → strings
	 * - R40: exp7 → ( Exp0 ) 
	 * - R41: exp7 → QFieldName 
	 * - R42: exp7 → id 
	 * - R43: exp7 → IfExpr
	 * 
	 * 
	 * @param throwError 
	 * 
	 * @return Expression_Boolean
	 */

	private Expression_Boolean exp7( boolean throwError) {
		boolean correct = false;
		Token tok = token_act;
		if (!existError) {
			System.out.println("***exp7***");
			if(checkTokenType("EOF")){
				setError(new Errors(49,tok,true,console));													
				existError =true;
			}
			if (checkTokenType("integer")){	
				System.out.println("Es un entero");
				e = new Int(tok.readAtribute());
				/*if(e.getValue(row).getType().equals("error")){
					if(!existError){ 
						int numError = Integer.parseInt(e.getValue(row).getVal());
						setError(new Errors(numError,tok,throwError,console));													
						existError =true;
					}
				}*/
				correct = true;
			} else if (checkTokenType("real")){
				e = new Real(tok.readAtribute());
				/*if(e.getValue(row).getType().equals("error")){
					if(!existError){ 
						int numError = Integer.parseInt(e.getValue(row).getVal());
						setError(new Errors(numError,tok,throwError,console));													
						existError =true;
					}
				}*/

				correct = true;
			} else if (checkTokenType("exponential")){
				//Expression e1 = e.deepCopy();
				e = new Exponential(tok.readAtribute());////DUDA EL ERROR
				/*if(e.getValue(row).getType().equals("error")){
					if(!existError){ 
						int numError = Integer.parseInt(e.getValue(row).getVal());
						setError(new Errors(numError,tok,throwError,console));													
						existError =true;
					}
				}*/
				correct = true;
			} else if (checkTokenType("string")){
				e = new Str(tok.readAtribute());
				/*if(e.getValue(row).getType().equals("error")){
					if(!existError){ 
						int numError = Integer.parseInt(e.getValue(row).getVal());
						setError(new Errors(numError,tok,throwError,console));													
						existError =true;
					}
				}*/
				correct = true;
			} else if (checkTokenType("identificator") || checkTokenType("catalog_id")){
				System.out.println("if id");
				if (checkTypeWithoutAdvancing(":=")){
					Expression_Boolean result1 = assignment();//exp8(throwError);
					correct = result1.isCorrect();
				} else{

					Variable v = new Variable(tok.readAtribute(),"","");
					if(!row.contains(v)){
						correct = false;
						if(!existError){ 
							setError(new Errors(48,tok,throwError,console));
							existError =true;
						}
					}
					else{

						//Value v1 = row.get(v);
						String name = tok.readAtribute();
						
						//Get Variable
						Variable variableRow = null;
						for(int i=0; i<row.size(); i++){
							if(v.equals(row.get(i))){
								variableRow = row.get(i);
							}
							
						}
						String type = variableRow.getType();
						String val = variableRow.getValue();
						//String value = v.getString();
						e = new Id(name,type,val);
						/*if(e.getValue(row).getType().equals("error")){
							if(!existError){ 
								int numError = Integer.parseInt(e.getValue(row).getVal());
								setError(new Errors(numError,tok,throwError,console));													
								existError =true;
							}
						}*/
						correct = true;

					}
				}


			}  else if (checkTokenType("wds_id")) {///////////////////???????????????
				Variable v = new Variable(tok.readAtribute(),"","");
				if(!row.contains(v)){
					correct = false;
					if(!existError){ 
						setError(new Errors(48,tok,throwError,console));
						existError =true;
					}
				}
				else{
					//Value v1 = row.get(v);
					String name = tok.readAtribute();
					
					//Get Variable
					Variable variableRow = null;
					for(int i=0; i<row.size(); i++){
						if(v.equals(row.get(i))){
							variableRow = row.get(i);
						}
						
					}
					String type = variableRow.getType();
					String val = variableRow.getValue();
					//String value = v.getString();
					e = new Id(name,type,val);
					/*if(e.getValue(row).getType().equals("error")){
						if(!existError){ 
							int numError = Integer.parseInt(e.getValue(row).getVal());
							setError(new Errors(numError,tok,throwError,console));													
							existError =true;
						}
					}*/
					correct = true;

				}
			} else if (checkAtribute("true") || checkAtribute("false")){
				if(tok.readAtribute().equals("true")){
					e = new True("boolean");
					/*if(e.getValue(row).getType().equals("error")){
						if(!existError){ 
							int numError = Integer.parseInt(e.getValue(row).getVal());
							setError(new Errors(numError,tok,throwError,console));													
							existError =true;
						}
					}*/
				} else if (tok.readAtribute().equals("false")) {
					e = new False("boolean");
					/*if(e.getValue(row).getType().equals("error")){
						if(!existError){ 
							int numError = Integer.parseInt(e.getValue(row).getVal());
							setError(new Errors(numError,tok,throwError,console));													
							existError =true;
						}
					}*/

				}
				correct = true;
			} else if (checkAtribute("not")) {
				Expression_Boolean result1 = exp5(throwError);
				boolean correct1 = result1.isCorrect();
				if (correct1){
					Expression e1 = e.deepCopy();
					correct = true;
					e = new Negation(e1);
					/*if(e.getValue(row).getType().equals("error")){
						if(!existError){ 
							int numError = Integer.parseInt(e.getValue(row).getVal());
							setError(new Errors(numError,tok,throwError,console));													
							existError =true;
						}
					}*/
				} else {
					correct = false;
					if(!existError){ 
						setError(new Errors(50,tok,throwError,console));
						existError =true;
					}
				}
			} else if (checkAtribute("-")) {				
				Expression_Boolean result1 = exp5(throwError);
				boolean correct1 = result1.isCorrect();
				//Expression e1 = e.deepCopy();
				if (correct1){
					Expression e1 = e.deepCopy();				
					correct = true;
					e = new Less(e1);
					/*if(e.getValue(row).getType().equals("error")){
						if(!existError){ 
							int numError = Integer.parseInt(e.getValue(row).getVal());
							setError(new Errors(numError,tok,throwError,console));													
							existError =true;
						}
					}*/
				} else {
					correct = false;
					if(!existError){
						setError(new Errors(51,tok,throwError,console));
						existError =true;
					}
				}
			} else if (checkAtribute("(")) {
				Expression_Boolean result1 = exp0(throwError);
				boolean correct1 = result1.isCorrect();
				if (correct1){
					if (checkAtribute(")"))
						correct = true;
					else if(!existError){
						setError(new Errors(7,tok,throwError,console));
						existError =true;
					}
				} else if(!existError) {
					setError(new Errors(2,tok,throwError,console));
					existError =true;
				}
			} else{
				Expression_Boolean result1 = ifExpr();
				boolean correct1 = result1.isCorrect();
				if (correct1){
					e = result1.getExpression();

					correct = true;
				}
			}
		}
		return new Expression_Boolean(e, correct);
	}




	/**
	 *   Method that evaluates the following grammar rules:
	 * 
	 * - R45:	op_adit → + | -	
	 * 
	 * @param
	 * 
	 * @return boolean
	 */
	private boolean opAdit(){
		boolean correct = false;
		if (!existError) {
			System.out.println("***OpAdit***");
			if (checkAtribute("+") || checkAtribute("-")){
				correct = true;		
			}
		}
		return correct;
	}


	/**
	 *  Method that evaluates the following grammar rules:
	 * 
	 * - R46:	op_mult → * | / | div | mod
	 * 
	 * @param
	 * 
	 * @return boolean
	 */
	private boolean opMult(){
		boolean correct = false;
		if (!existError) {
			System.out.println("***OpMult***");
			if(checkAtribute("div")|| checkAtribute("mod") ||checkAtribute("*") ||
					checkAtribute("/")){
				correct = true;
			}
		}
		return correct;
	}


	/**
	 *  Method that evaluates the following grammar rules:
	 * 
	 * - R47: op_rel →  '>' | '<' | '>=' | '<='
	 * 
	 * @param
	 * 
	 * @return boolean
	 */
	private boolean opRel() {
		boolean correct = false;
		if (!existError) {
			System.out.println("***OpRelacional***");
			if(checkAtribute("<=") || (checkAtribute(">=")) ||
					(checkAtribute("<")) ||(checkAtribute(">"))){
				correct=true;
			}
		}
		return correct;
	}


	/**
	 *  Method that evaluates the following grammar rules:
	 *
	 * - R48: op_eq → <> | =
	 * 
	 * @param
	 * 
	 * @return boolean
	 */
	private boolean opEq() {
		boolean correct = false;
		if (!existError) {
			System.out.println("***OpIgual***");
			if (checkAtribute("<>") || (checkAtribute("="))){
				correct=true;
			}
		}
		return correct;
	}


	/**
	 * Method that evaluates the following grammar rules:
	 * 
	 * - R49: 	op_log → and | or
	 * 
	 * @param
	 * 
	 * @return boolean
	 */
	private boolean opLog(){
		boolean correct = false;
		if (!existError) {
			System.out.println("***OpLog***");
			if(checkAtribute("and") || (checkAtribute("or"))){
				correct=true;		
			}
		}
		return correct;
	}
}
