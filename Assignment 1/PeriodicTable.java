package Assignment1;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PeriodicTable implements PeriodicTableInterface {
    protected final String TABLE[][] = {
            {"H", "1"}, {"He", "18"}, {"Li", "1"}, {"Be", "2"}, {"B", "13"}, {"C", "14"}, {"N", "15"}, {"O", "16"}, {"F", "17"},
            {"Ne", "18"}, {"Na", "1"}, {"Mg", "2"}, {"Al", "13"}, {"Si", "14"}, {"P", "15"}, {"S", "16"}, {"Cl", "17"}, {"Ar", "18"},
            {"K", "1"}, {"Ca", "2"}, {"Sc", "3"}, {"Ti", "4"}, {"V", "5"}, {"Cr", "6"}, {"Mn", "7"}, {"Fe", "8"}, {"Co", "9"}, {"Ni", "10"},
            {"Cu", "11"}, {"Zn", "12"}, {"Ga", "13"}, {"Ge", "14"}, {"As", "15"}, {"Se", "16"}, {"Br", "17"}, {"Kr", "18"},
            {"Rb", "1"}, {"Sr", "2"}, {"Y", "3"}, {"Zr", "4"}, {"Nb", "5"}, {"Mo", "6"}, {"Tc", "7"}, {"Ru", "8"}, {"Rh", "9"},
            {"Pd", "10"}, {"Ag", "11"}, {"Cd", "12"}, {"In", "13"}, {"Sn", "14"}, {"Sb", "15"}, {"Te", "16"}, {"I", "17"}, {"Xe", "18"},
            {"Cs", "1"}, {"Ba", "2"}, {"La", "-11"}, {"Ce", "-12"}, {"Pr", "-13"}, {"Nd", "-14"}, {"Pm", "-15"}, {"Sm", "-16"},
            {"Eu", "-17"}, {"Gd", "-18"}, {"Tb", "-19"}, {"Dy", "-20"}, {"Ho", "-21"}, {"Er", "-22"}, {"Tm", "-23"}, {"Yb", "-24"}, {"Lu", "-25"},
            {"Hf", "4"}, {"Ta", "5"}, {"W", "6"}, {"Re", "7"}, {"Os", "8"}, {"Ir", "9"}, {"Pt", "10"}, {"Au", "11"}, {"Hg", "12"},
            {"Tl", "13"}, {"Pb", "14"}, {"Bi", "15"}, {"Po", "16"}, {"At", "17"}, {"Rn", "18"}, {"Fr", "1"}, {"Ra", "2"}, {"Ac", "-31"},
            {"Th", "-32"}, {"Pa", "-33"}, {"U", "-34"}, {"Np", "-35"}, {"Pu", "-36"}, {"Am", "-37"}, {"Cm", "-38"}, {"Bk", "-39"},
            {"Cf", "-40"}, {"Es", "-41"}, {"Fm", "-42"}, {"Md", "-43"}, {"No", "-44"}, {"Lr", "-45"}, {"Rf", "4"}, {"Db", "5"}, {"Sg", "6"},
            {"Bh", "7"}, {"Hs", "8"}, {"Mt", "9"}, {"Ds", "10"}, {"Rg", "11"}, {"Cn", "12"}, {"Nh", "13"}, {"Fl", "14"}, {"Mc", "15"},
            {"Lv", "16"}, {"Ts", "17"}, {"Og", "18"}
    };

    Scanner reader = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("000");

    public void printTables() {
        int start, end;
        boolean includeLaAc;
        char input;

        System.out.print("Enter 'y' if you want to include Lanthanides and Actinides: ");
        input = reader.next().charAt(0);

        includeLaAc = (input == 'Y' || input == 'y');

        if (includeLaAc) {
            System.out.println("...Y selected...");
        } else {
            System.out.println("...N selected...");
        }   

        System.out.print("Enter number of first element to print: ");
        try 
        {
            start = reader.nextInt();
        } 
        catch (InputMismatchException e) {
            start = 1;
            System.out.println("...Defaulting to 1...");
        } finally 
        {
            reader.nextLine();
        }
        

        System.out.print("Enter number of last element to print: ");
        try 
        {
            end = reader.nextInt();
        } catch (InputMismatchException e) 
        {
            end = 118;
            System.out.println("...Defaulting to 118...");
        } 
        finally 
        {
            reader.nextLine();
        }

        if (end > 118 || end < 1) 
        {
            end = 118;
        }

        if (start > 118 || start < 2) 
        {
            start = 1;
        }

        if (start > end) 
        {
            int temp = start;
            start = end;
            end = temp;
        }

        boolean isLaAc;
        int lastGroup = 0;
        System.out.print("\n");

        for (int i = start - 1; i < end; i++) {
            int group = Integer.parseInt(TABLE[i][1]);
            isLaAc = group < 1;

            if (!isLaAc) {
                if (group > lastGroup) {
                    int gap = group - lastGroup - 1;
                    for (int j = 0; j < gap; j++) {
                        System.out.print("\t");
                    }
                }

                int formattedNum = (i + 1);
                String theElement = df.format(formattedNum) + " " + TABLE[i][0];

                if (group == 18)
                {
                    System.out.print(theElement + "\n");
                }
                else
                {
                    System.out.print(theElement + "\t");
                }
                lastGroup = group;
            }
        }

        if (includeLaAc) {
            System.out.println("\n");

            for (int i = 56; i <= 70; i++) {
                if (i + 1 >= start && i + 1 <= end) {
                    int formattedNum = (i + 1);
                    System.out.print(df.format(formattedNum) + " " + TABLE[i][0] + "\t");
                }
            }
            System.out.println();

            for (int i = 88; i <= 102; i++) {
                if (i + 1 >= start && i + 1 <= end) {
                    int formattedNum = (i + 1);
                    System.out.print(df.format(formattedNum) + " " + TABLE[i][0] + "\t");
                }
            }
            System.out.println();
        }
    }

    public void printGroups() {}
    }