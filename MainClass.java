import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass
{
    /**
     * @param args
     * @throws IOException
     * @throws NumberFormatException
     */
    public static void main(String[] args) throws NumberFormatException, IOException {
        GetOptimums optimumValues = new GetOptimums();
        optimumValues.ReadExcelFile();
        GetData datasetValues = new GetData();
        ArrayList<ProblemSet> dataSets_ils = datasetValues.GetDataSets();
        ArrayList<ProblemSet> dataSets_tabu = dataSets_ils;
        System.out.println("u20494166 Tawanda Jimu ");
        System.out.println("SELECT ONE OF THE FOLLOWING : ");
        System.out.println("1. Iterative Local Search ");
        System.out.println("2. Tabu Search Algorithm ");

        Scanner scannerObj = new Scanner(System.in);  // Create a Scanner object

        int choice = Integer.parseInt(scannerObj.nextLine());   

        if (choice == 1) 
        {
            for (int i = 0; i < dataSets_ils.size() ; i++) 
            {
                for (int j = 0; j < dataSets_ils.get(i).ProblemInstances.size(); j++) 
                {
                    for (int j2 = 0; j2 < optimumValues.Optimum_Values.get(i).ProblemInstances.size(); j2++) 
                    {
                        if(dataSets_ils.get(i).ProblemInstances.get(j).name.equals(optimumValues.Optimum_Values.get(i).ProblemInstances.get(j2).Problem_Instance+".txt"))
                        {
                            dataSets_ils.get(i).ProblemInstances.get(j).known_optimum =  optimumValues.Optimum_Values.get(i).ProblemInstances.get(j2).Known_Opt_Value;
                        }
                    }
                }
            }
            System.out.println("");
            System.out.println("SELECT WHICH PROBLEM SET TO RUN : ");
            System.out.println("1. ALL ");
            System.out.println("2. Falkenauer T ");
            System.out.println("3. Falkenauer U ");
            System.out.println("4. Hard 28 ");
            System.out.println("5. Scholl 1 ");
            System.out.println("6. Scholl 2 ");
            System.out.println("7. Scholl 3 ");
            System.out.println("8. Schwerin 1 ");
            System.out.println("9. Schwerin 2 ");
            System.out.println("10. Waescher");

            choice = scannerObj.nextInt();   
            int start_index =0 , end_Index = 0;
            switch (choice) {
                case 1:
                    start_index = 0;
                    end_Index = 9;
                    break;
                case 2:
                    start_index = 0;
                    end_Index = 1;
                    break;
                case 3:
                    start_index = 1;
                    end_Index = 2;
                    break;
                case 4:
                    start_index = 2;
                    end_Index = 3;
                    break;
                case 5:
                    start_index = 3;
                    end_Index = 4;
                    break;
                case 6:
                    start_index = 4;
                    end_Index = 5;
                    break;
                case 7:
                    start_index = 5;
                    end_Index = 6;
                    break;
                case 8:
                    start_index = 6;
                    end_Index = 7;
                    break;
                case 9:
                    start_index = 7;
                    end_Index = 8;
                    break;
                case 10:
                    start_index = 8;
                    end_Index = 9;
                    break;
                default:
                    break;
            }
            System.out.println("");
            for (int i = start_index; i < end_Index ; i++) 
            {
                int count_optimality = 0;
                int count_near_optimality = 0;
                int count_near_optimality2 = 0;
                int count_near_optimality3 = 0;
                int count_near_optimalityrest = 0;

                System.out.println(dataSets_tabu.get(i).ProblemSetName);
                System.out.println("Size : "+dataSets_ils.get(i).ProblemInstances.size());

                long elapsedTime = 0;
                int average = 0;
                for (int j = 0; j < dataSets_ils.get(i).ProblemInstances.size(); j++) 
                {
                    average += dataSets_ils.get(i).ProblemInstances.get(j).items_count;
                    long start = System.nanoTime();    
                    dataSets_ils.get(i).ProblemInstances.get(j).ILS();
                    elapsedTime += System.nanoTime() - start; 
                        if (dataSets_tabu.get(i).ProblemInstances.get(j).known_optimum == dataSets_tabu.get(i).ProblemInstances.get(j).local_optimum )
                        {
                            count_optimality++;
                        }
                        else if((dataSets_tabu.get(i).ProblemInstances.get(j).known_optimum+1) == (dataSets_tabu.get(i).ProblemInstances.get(j).local_optimum ))
                        {
                            count_near_optimality++;
                        }  
                        else if((dataSets_tabu.get(i).ProblemInstances.get(j).known_optimum+2) == (dataSets_tabu.get(i).ProblemInstances.get(j).local_optimum))
                        {
                            count_near_optimality2++;
                        }
                        else if((dataSets_tabu.get(i).ProblemInstances.get(j).known_optimum+3) == (dataSets_tabu.get(i).ProblemInstances.get(j).local_optimum))
                        {
                            count_near_optimality3++;
                        }   
                        else 
                        {
                            count_near_optimalityrest++;
                        }     
                }

                System.out.println("Average Item Count: "+ (average/dataSets_ils.get(i).ProblemInstances.size()));
                System.out.println("Elapsed Time (nanoseconds): "+ (elapsedTime/dataSets_ils.get(i).ProblemInstances.size()));
                System.out.println("Optimum: "+ count_optimality);
                System.out.println("Near Optimality 1: "+ count_near_optimality);
                System.out.println("Near Optimality 2: "+ count_near_optimality2);
                System.out.println("Near Optimality 3: "+ count_near_optimality3);
                System.out.println("Near Optimality n > 3 : "+ count_near_optimalityrest);
                System.out.println("");
            }
        }
        else if (choice == 2) 
        {
            for (int i = 0; i < dataSets_tabu.size() ; i++) 
            {
                for (int j = 0; j < dataSets_tabu.get(i).ProblemInstances.size(); j++) 
                {
                    for (int j2 = 0; j2 < optimumValues.Optimum_Values.get(i).ProblemInstances.size(); j2++) 
                    {
                        if(dataSets_tabu.get(i).ProblemInstances.get(j).name.equals(optimumValues.Optimum_Values.get(i).ProblemInstances.get(j2).Problem_Instance+".txt"))
                        {
                            dataSets_tabu.get(i).ProblemInstances.get(j).known_optimum =  optimumValues.Optimum_Values.get(i).ProblemInstances.get(j2).Known_Opt_Value;
                        }
                    }
                }
            }
            System.out.println("");
            System.out.println("SELECT WHICH PROBLEM SET TO RUN : ");
            System.out.println("1. ALL ");
            System.out.println("2. Falkenauer T ");
            System.out.println("3. Falkenauer U ");
            System.out.println("4. Hard 28 ");
            System.out.println("5. Scholl 1 ");
            System.out.println("6. Scholl 2 ");
            System.out.println("7. Scholl 3 ");
            System.out.println("8. Schwerin 1 ");
            System.out.println("9. Schwerin 2 ");
            System.out.println("10. Waescher");

            choice = scannerObj.nextInt();   
            int start_index =0 , end_Index = 0;
            switch (choice) {
                case 1:
                    start_index = 0;
                    end_Index = 9;
                    break;
                case 2:
                    start_index = 0;
                    end_Index = 1;
                    break;
                case 3:
                    start_index = 1;
                    end_Index = 2;
                    break;
                case 4:
                    start_index = 2;
                    end_Index = 3;
                    break;
                case 5:
                    start_index = 3;
                    end_Index = 4;
                    break;
                case 6:
                    start_index = 4;
                    end_Index = 5;
                    break;
                case 7:
                    start_index = 5;
                    end_Index = 6;
                    break;
                case 8:
                    start_index = 6;
                    end_Index = 7;
                    break;
                case 9:
                    start_index = 7;
                    end_Index = 8;
                    break;
                case 10:
                    start_index = 8;
                    end_Index = 9;
                    break;
                default:
                    break;
            }
            System.out.println("");

            for (int i = start_index; i < end_Index ; i++) 
            {
                int count_optimality = 0;
                int count_near_optimality = 0;
                int count_near_optimality2 = 0;
                int count_near_optimality3 = 0;
                int count_near_optimalityrest = 0;

                System.out.println(dataSets_tabu.get(i).ProblemSetName);
                System.out.println("Size: "+dataSets_tabu.get(i).ProblemInstances.size());

                long elapsedTime = 0;
                for (int j = 0; j < dataSets_tabu.get(i).ProblemInstances.size(); j++) 
                {
                    long start = System.nanoTime();    
                    dataSets_tabu.get(i).ProblemInstances.get(j).Tabu();
                    elapsedTime += System.nanoTime() - start;
                        
                    if (dataSets_tabu.get(i).ProblemInstances.get(j).known_optimum == dataSets_tabu.get(i).ProblemInstances.get(j).local_optimum )
                    {
                        count_optimality++;
                    }
                    else if ((dataSets_tabu.get(i).ProblemInstances.get(j).known_optimum+1) == (dataSets_tabu.get(i).ProblemInstances.get(j).local_optimum) )
                    {
                        count_near_optimality++;
                    } 
                    else if ((dataSets_tabu.get(i).ProblemInstances.get(j).known_optimum+2) == (dataSets_tabu.get(i).ProblemInstances.get(j).local_optimum) )
                    {
                        count_near_optimality2++;
                    }      
                    else if ((dataSets_tabu.get(i).ProblemInstances.get(j).known_optimum+3) == (dataSets_tabu.get(i).ProblemInstances.get(j).local_optimum) )
                    {
                        count_near_optimality3++;
                    }
                    else{
                        count_near_optimalityrest++;
                    }
                }
                
                System.out.println("Elapsed Time (nanoseconds): "+ (elapsedTime/dataSets_ils.get(i).ProblemInstances.size()));
                System.out.println("Optimum: "+ count_optimality);
                System.out.println("Near Optimality 1: "+ count_near_optimality);
                System.out.println("Near Optimality 2: "+ count_near_optimality2);
                System.out.println("Near Optimality 3: "+ count_near_optimality3);
                System.out.println("Near Optimality n > 3 : "+ count_near_optimalityrest);
                System.out.println("");
            }
            scannerObj.close();
        }
    }
}
