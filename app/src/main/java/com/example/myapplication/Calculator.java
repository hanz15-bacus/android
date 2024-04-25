package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Calculator extends AppCompatActivity {


    TextView result;
    TextView lastnum;

    Button zero;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;

    Button add;
    Button subtract;
    Button multiply;
    Button divide;
    Button equals;
    Button point;

    int reference_to_last_num = 0;
    boolean hasChanged = false;
    Stack<String> calculation = new Stack<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        getSupportActionBar().hide();


        result = (TextView) findViewById(R.id.result_textview);

        zero = (Button) findViewById(R.id.button_zero);
        one = (Button) findViewById(R.id.button_one);
        two = (Button) findViewById(R.id.button_two);
        three = (Button) findViewById(R.id.button_three);
        four = (Button) findViewById(R.id.button_four);
        five = (Button) findViewById(R.id.button_five);
        six = (Button) findViewById(R.id.button_six);
        seven = (Button) findViewById(R.id.button_seven);
        eight = (Button) findViewById(R.id.button_eight);
        nine = (Button) findViewById(R.id.button_nine);

        List<Button> buttons = new ArrayList<>();
        buttons.add(zero);
        buttons.add(one);
        buttons.add(two);
        buttons.add(three);
        buttons.add(four);
        buttons.add(five);
        buttons.add(six);
        buttons.add(seven);
        buttons.add(eight);
        buttons.add(nine);

//        Stack<String> calculation = new Stack<>();

        for (Button b : buttons) {
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button x = (Button) view;
                    String num = x.getText().toString();

                    if (result.getText().equals("0")) {
                        result.setText(num);
                    } else {
                        if (result.getText().toString().substring(reference_to_last_num, result.length()).equals("0") && !hasChanged) {
                            result.setText(result.getText().toString().substring(0, reference_to_last_num) + num);
                        } else {
                            result.setText(result.getText() + num);
                        }
                    }

                    if (calculation.isEmpty() || hasChanged) {
                        calculation.push(result.getText().toString().substring(reference_to_last_num, result.length())); //push the number to the stack first
                        hasChanged = false;
                    } else {
                        calculation.pop();
                        calculation.push(result.getText().toString().substring(reference_to_last_num, result.length())); //push the number to the stack first
                    }

                    String res = calculateSequence(((Stack<String>) calculation.clone()));


                    try {
                        if (isNotInteger(res)) {
                            lastnum.setText("= " + Float.parseFloat(res));
                        } else {
                            lastnum.setText("= " + ((int) Float.parseFloat(res)));
                        }
                    } catch (NumberFormatException ne) {
                        lastnum.setText(res);
                    }
                }
            });
        }

        point = (Button) findViewById(R.id.button_point);
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button y = (Button) view;
                String p = y.getText().toString();

                if (calculation.isEmpty()) {
                    result.setText("0.");
                    calculation.push("0");
                    System.out.println(calculation.isEmpty());
                    System.out.println(calculation.peek().toString());
                } else if (hasChanged) {
                    result.setText(result.getText() + "0.");
                    calculation.push("0");
                    System.out.println(calculation.isEmpty());
                    System.out.println(calculation.peek().toString());
                    hasChanged = false;
                } else if (!result.getText().toString().substring(reference_to_last_num, result.length()).contains(".") && calculation.size() % 2 != 0) {
                    result.setText(result.getText() + p);
                } else if (result.getText().charAt(result.length() - 1) == '.') {
                    result.setText(result.getText().toString().substring(0, result.length() - 1));

                    System.out.println(calculation.isEmpty());
                    System.out.println(calculation.peek().toString());

//                    if (calculation.peek().toString() == "0") {
//                        calculation.pop();
//                        hasChanged = false;
//                    }
                }
            }
        });

        add = (Button) findViewById(R.id.add);
        subtract = (Button) findViewById(R.id.subtract);
        multiply = (Button) findViewById(R.id.multiply);
        divide = (Button) findViewById(R.id.divide);
        equals = (Button) findViewById(R.id.equals);

        List<Button> ops = new ArrayList<>();
        ops.add(add);
        ops.add(subtract);
        ops.add(multiply);
        ops.add(divide);

        lastnum = (TextView) findViewById(R.id.lastnum_textview);

        for (Button b : ops) {
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button o = (Button) view;
                    String operator = o.getText().toString();

                    System.out.println(calculation.isEmpty());
                    switch (operator) {
                        case "+":
                            if (!(result.getText().toString().charAt(result.length() - 1) == '.') && !calculation.isEmpty()) {
                                if (!calculation.peek().equals("+") && !hasChanged) {
                                    calculation.push("+");
                                    result.setText(result.getText() + "+");
                                } else {
                                    result.setText(result.getText().toString().substring(0, result.length() - 1) + "+");
                                    calculation.pop();
                                    calculation.push("+");
                                }

                                reference_to_last_num = result.length();
                                hasChanged = true;
                            }
                            break;
                        case "-":
                            if (!(result.getText().toString().charAt(result.length() - 1) == '.') && !calculation.isEmpty()) {
                                if (!calculation.peek().equals("-") && !hasChanged) {
                                    calculation.push("-");
                                    result.setText(result.getText() + "-");
                                } else {
                                    result.setText(result.getText().toString().substring(0, result.length() - 1) + "-");
                                    calculation.pop();
                                    calculation.push("-");
                                }

                                reference_to_last_num = result.length();
                                hasChanged = true;
                            }
                            break;
                        case "*":
                            if (!(result.getText().toString().charAt(result.length() - 1) == '.') && !calculation.isEmpty()) {
                                if (!calculation.peek().equals("*") && !hasChanged) {
                                    calculation.push("*");
                                    result.setText(result.getText() + "*");
                                } else {
                                    result.setText(result.getText().toString().substring(0, result.length() - 1) + "*");
                                    calculation.pop();
                                    calculation.push("*");
                                }

                                reference_to_last_num = result.length();
                                hasChanged = true;
                            }
                            break;
                        case "/":
                            if (!(result.getText().toString().charAt(result.length() - 1) == '.') && !calculation.isEmpty()) {
                                if (!calculation.peek().equals("/") && !hasChanged) {
                                    calculation.push("/");
                                    result.setText(result.getText() + "/");
                                } else {
                                    result.setText(result.getText().toString().substring(0, result.length() - 1) + "/");
                                    calculation.pop();
                                    calculation.push("/");
                                }

                                reference_to_last_num = result.length();
                                hasChanged = true;
                            }
                            break;
                    }

                    if (!calculation.isEmpty()) {
                        System.out.println(calculation.peek().toString());
                    }
                }
            });
        }

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(result.getText().toString().charAt(result.length() - 1) == '.') && calculation.size() % 2 != 0) {
                    String res = calculateMDAS(((Stack<String>) calculation.clone()));

                    try {
                        if (isNotInteger(res)) {
                            lastnum.setText("= " + Float.parseFloat(res));
                        } else {
                            lastnum.setText("= " + ((int) Float.parseFloat(res)));
                        }
                    } catch (NumberFormatException ne) {
                        lastnum.setText(res);
                    }

                    result.setText("0");
                    calculation = new Stack<>();
                    hasChanged = false;
                    reference_to_last_num = 0;
                }
            }
        });
    }

    public boolean isNotInteger(String s) {
        float num = Float.parseFloat(s);

        return num - Math.floor(num) > 0;
    }

    public String calculateSequence(Stack s) {
        String result = "";

        //reverse stack
        Stack<String> final_stack = new Stack<>();
        while (!s.isEmpty()) {
            final_stack.push(s.pop().toString());
        }
        System.out.println("stack size: " + final_stack.size());
        System.out.println("checking stack top before solving: " + final_stack.peek());
        //solve stack to solve sequentially
        while (!(final_stack.size() == 1)) {
            float initial_num = Float.parseFloat(final_stack.pop());
            float second_num, res;
            switch (final_stack.pop()) { /*solving for the operator*/
                case "+":
                    second_num = Float.parseFloat(final_stack.pop());
                    res = initial_num + second_num;
                    final_stack.push(String.valueOf(res));
                    break;
                case "-":
                    second_num = Float.parseFloat(final_stack.pop());
                    res = initial_num - second_num;
                    final_stack.push(String.valueOf(res));
                    break;
                case "*":
                    second_num = Float.parseFloat(final_stack.pop());
                    res = initial_num * second_num;
                    final_stack.push(String.valueOf(res));
                    break;
                case "/":
                    second_num = Float.parseFloat(final_stack.pop());
                    res = initial_num / second_num;

                    if (second_num == 0) {
                        return "Error: cannot divide by 0.";
                    }

                    final_stack.push(String.valueOf(res));
                    break;
            }
        }
        //final num is result
        result = final_stack.pop();
        return result;
    }

    public String calculateMDAS(Stack s) {
        String result = "";

        //make a stack to use for the final stack
        Stack<String> secondstack = new Stack<>();

        //run through the s stack: push nums by default, evaluate any operator following MDAS by popping from both stacks before pushing again
        while (!s.isEmpty()) {
            float first_num;
            float second_num, res;
            switch (s.peek().toString()) {
                case "*":
                    s.pop();
                    first_num = Float.parseFloat(s.pop().toString());
                    second_num = Float.parseFloat(secondstack.pop());
                    res = first_num * second_num;
                    secondstack.push(String.valueOf(res));
                    break;
                case "/":
                    s.pop();
                    first_num = Float.parseFloat(s.pop().toString());
                    second_num = Float.parseFloat(secondstack.pop());

                    if (second_num == 0) {
                        return "Error: cannot divide by 0.";
                    }

                    res = first_num / second_num;
                    secondstack.push(String.valueOf(res));
                    break;
                default:
                    secondstack.push(s.pop().toString());
            }
        }

        s = stackReverser(((Stack<String>) secondstack.clone())); //reverse the stack before parsing another operator
        secondstack = new Stack<>();

        while (!s.isEmpty()) {
            float first_num;
            float second_num, res;
            switch (s.peek().toString()) {
                case "+":
                    s.pop();
                    first_num = Float.parseFloat(s.pop().toString());
                    second_num = Float.parseFloat(secondstack.pop());
                    res = first_num + second_num;
                    secondstack.push(String.valueOf(res));
                    break;
                case "-":
                    s.pop();
                    first_num = Float.parseFloat(s.pop().toString());
                    second_num = Float.parseFloat(secondstack.pop());
                    res = first_num - second_num;
                    secondstack.push(String.valueOf(res));
                    break;
                default:
                    secondstack.push(s.pop().toString());
            }
        }

        result = secondstack.pop();
        return result;
    }

    public Stack stackReverser(Stack s) {
        Stack<String> reversed = new Stack<>();

        while (!s.isEmpty()) {
            reversed.push(s.pop().toString());
        }
        return reversed;
    }
}