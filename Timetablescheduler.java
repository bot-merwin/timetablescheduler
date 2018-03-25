/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablescheduler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author micku
 */
class SubTeachMap
{
 String sub;
 int indteach;
}
public class Timetablescheduler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<String> teachers=new ArrayList();
        teachers.add("A");
        teachers.add("B");
        teachers.add("C");
        teachers.add("D");
        teachers.add("E");
        teachers.add("F");
        teachers.add("G");
        String Monday[][]=new String[4][7];
        SubTeachMap stm[][]=new SubTeachMap[2][4];
        int teachflag[][]=new int[7][7];
        int labind[]={0,1,4};
        int labmax=3,roomcntmax=3,roomcnt1=0,roomcnt2=0;
        int labcount[][]=new int[4][4];
        String Tuesday[][]=new String[4][7];
        String Wednesday[][]=new String[4][7];
        String Thursday[][]=new String[4][7];
        String Friday[][]=new String[4][7];
        String teacher=new String();
        
        //************initialization*************
        
        for(int i=0;i<4;i++)
        {
         for(int j=0;j<7;j++)
         {
          Monday[i][j]="NA";
          Tuesday[i][j]="NA";
          Wednesday[i][j]="NA";
          Thursday[i][j]="NA";
          Friday[i][j]="NA";
          
         }   
        }
        
        //**********enter the subjects and teachers************
        
        
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<2;i++)
        {
         System.out.println("For semester "+(i*2+4));
         
         for(int j=0;j<4;j++)
         {
          System.out.println("enter the name of subject : ");
          stm[i][j]=new SubTeachMap();
          stm[i][j].sub=sc.nextLine();
          System.out.println("enter the name of the teacher for "+stm[i][j].sub);
          teacher=sc.nextLine();
          if(teachers.contains(teacher))
            {
            stm[i][j].indteach=teachers.indexOf(teacher);
            }
          else
            {
            System.out.println("enter the name of teacher from the list operation not performed");
            j--;
            }
          
          }
         
        }
        
        //**************assigning labs************** 
        
        Random r=new Random();
        int x,y,count=0,z=0;
        
        // MONDAY
        
        
        for(int i=0;i<4;i++)
        {
         if(i>z)
             count=0;
         x=r.nextInt(4);y=r.nextInt(3);
         if(labind[y]<3)
         {      
         if(  labcount[i][x]<labmax  && teachflag[stm[i/2][x].indteach][labind[y]]==0 && teachflag[stm[i/2][x].indteach][labind[y]+1]==0 && roomcnt1<=roomcntmax&& teachflag[stm[i/2][x].indteach][labind[y]+4]==0 )
         {
          for(int j=labind[y];j<labind[y]+3;j++)
          {
              Monday[i][j]=stm[i/2][x].sub;
              teachflag[stm[i/2][x].indteach][j]=1;
              roomcnt1++;
          }
          labcount[i][x]+=3;
         }
         else if(count==25)
         {
          
         } 
         else
         {
          z=i;   
          i--;
          count++;
         }
        }
         
         else
         {
          if(  labcount[i][x]<labmax  && teachflag[stm[i/2][x].indteach][labind[y]]==0 && teachflag[stm[i/2][x].indteach][labind[y]+1]==0 && roomcnt2<=roomcntmax )
         {
          for(int j=labind[y];j<labind[y]+3;j++)
          {
              Monday[i][j]=stm[i/2][x].sub;
              teachflag[stm[i/2][x].indteach][j]=1;
              roomcnt2++;
          }
          labcount[i][x]+=3;
         }
         else if(count==25)
         {
          
         } 
         else
         {
          z=i;   
          i--;
          count++;
         }
         
         }
         
        
        }
        
        //Tuesday
        z=0;count=0;
       
         for(int i=0;i<7;i++)
        {
        for(int j=0;j<7;j++)
        {
        teachflag[i][j]=0;
        }
        
        }
      
         for(int i=0;i<4;i++)
        {
         if(i>z)
             count=0;
         x=r.nextInt(4);y=r.nextInt(3);
         if(  labcount[i][x]<labmax  && teachflag[stm[i/2][x].indteach][labind[y]]==0 && teachflag[stm[i/2][x].indteach][labind[y]+1]==0 )
         {
          for(int j=labind[y];j<labind[y]+3;j++)
          {
              Tuesday[i][j]=stm[i/2][x].sub;
              teachflag[stm[i/2][x].indteach][j]=1;
          }
          labcount[i][x]+=3;
         }
         else if(count==25)
         {
          
         } 
         else
         {
          z=i;   
          i--;
          count++;
         }
        
        }
         
         //Wednesday
          z=0;count=0;
           for(int i=0;i<7;i++)
        {
        for(int j=0;j<7;j++)
        {
        teachflag[i][j]=0;
        }
        
        }
    
        for(int i=0;i<4;i++)
        {
         if(i>z)
             count=0;
         x=r.nextInt(4);y=r.nextInt(3);
         if(  labcount[i][x]<labmax  && teachflag[stm[i/2][x].indteach][labind[y]]==0 && teachflag[stm[i/2][x].indteach][labind[y]+1]==0 )
         {
          for(int j=labind[y];j<labind[y]+3;j++)
          {
              Wednesday[i][j]=stm[i/2][x].sub;
              teachflag[stm[i/2][x].indteach][j]=1;
          }
          labcount[i][x]+=3;
         }
         else if(count==25)
         {
         
         } 
         else
         {
          z=i;   
          i--;
           count++;
         }
        
        }
        
        //Thursday
        
          z=0;count=0;
          for(int i=0;i<7;i++)
        {
        for(int j=0;j<7;j++)
        {
        teachflag[i][j]=0;
        
        }
     
        }
        
      
         for(int i=0;i<4;i++)
        {
         if(i>z)
             count=0;
         x=r.nextInt(4);y=r.nextInt(3);
         if(  labcount[i][x]<labmax  && teachflag[stm[i/2][x].indteach][labind[y]]==0 && teachflag[stm[i/2][x].indteach][labind[y]+1]==0 )
         {
          for(int j=labind[y];j<labind[y]+3;j++)
          {
              Thursday[i][j]=stm[i/2][x].sub;
              teachflag[stm[i/2][x].indteach][j]=1;
          }
          labcount[i][x]+=3;
         }
         else if(count==25)
         {
          
         } 
         else
         {
          z=i;   
          i--;
           count++;
         }
        
        }
         
         
         //Friday
         
           z=0;count=0;
          for(int i=0;i<7;i++)
        {
        for(int j=0;j<7;j++)
        {
        teachflag[i][j]=0;
        }
      
        }
        
         
          for(int i=0;i<4;i++)
        {
         if(i>z)
             count=0;
         x=r.nextInt(4);y=r.nextInt(3);
         if(  labcount[i][x]<labmax  && teachflag[stm[i/2][x].indteach][labind[y]]==0 && teachflag[stm[i/2][x].indteach][labind[y]+1]==0 )
         {
          for(int j=labind[y];j<labind[y]+3;j++)
          {
              Friday[i][j]=stm[i/2][x].sub;
              teachflag[stm[i/2][x].indteach][j]=1;
          }
          labcount[i][x]+=3;
         }
         else if(count==25)
         {
          
         } 
         else
         {
          z=i;   
         
          i--;
           count++;
         }
        
        }
         //displaying
        
        //Monday
        System.out.println("==============================");
        for(int i=0;i<4;i++)
        {
         for(int j=0;j<7;j++)
         {
          System.out.print(Monday[i][j]+" ");
         }
         System.out.println("");
        }
        
        //Tuesday
        
        System.out.println("==============================");
        for(int i=0;i<4;i++)
        {
         for(int j=0;j<7;j++)
         {
          System.out.print(Tuesday[i][j]+" ");
         }
         System.out.println("");
        }
        
        //wednesday
        System.out.println("==============================");
        for(int i=0;i<4;i++)
        {
         for(int j=0;j<7;j++)
         {
          System.out.print(Wednesday[i][j]+" ");
         }
         System.out.println("");
        }
        
        //Thursday
        System.out.println("==============================");
        for(int i=0;i<4;i++)
        {
         for(int j=0;j<7;j++)
         {
          System.out.print(Thursday[i][j]+" ");
         }
         System.out.println("");
        }
        
        //Friday
        
        System.out.println("==============================");
        for(int i=0;i<4;i++)
        {
         for(int j=0;j<7;j++)
         {
          System.out.print(Friday[i][j]+" ");
         }
         System.out.println("");
        }
        
                
    }
    
}

