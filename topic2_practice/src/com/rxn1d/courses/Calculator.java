package com.rxn1d.courses;


/**
 * @author Ievgen Tararaka
 *
 */
public class Calculator {

    public static void main(String[] args) {
        float result=0;
        System.out.println("---> START Calculator application <---");
        while (true){
            String[] in = ConsoleReader.readFromConsole();
            if (in[0].equals("exit"))
                break;
            if (in.length==3)
                result=doAll(in);
            else
                result=someOperation(in,result);
            System.out.println(result);
        }
        System.out.println("---> EXIT Calculator application <---");
    }
    static  float doAll (String [] read){
        float result=0;
        switch (read[1]){
            case "/":
                result=Float.parseFloat(read[0])/Float.parseFloat(read[2]);
                break;
            case "*":
                result=Float.parseFloat(read[0])*Float.parseFloat(read[2]);
                break;
            case "+":
                result=Float.parseFloat(read[0])+Float.parseFloat(read[2]);
                break;
            case "-":
                result=Float.parseFloat(read[0])-Float.parseFloat(read[2]);
                break;
            default:
        }

        return result;
    }
    static float someOperation (String [] read, float result){
        switch (read[0]){
            case "/":
                result=result/Float.parseFloat(read[1]);
                break;
            case "*":
                result=result*Float.parseFloat(read[1]);
                break;
            case "+":
                result=result+Float.parseFloat(read[1]);
                break;
            case "-":
                result=result-Float.parseFloat(read[1]);
                break;
            default:
        }

        return result;
    }

}

