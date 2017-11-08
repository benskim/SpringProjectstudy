package com.sist.music;
import java.util.*;
import java.io.*;
public class MusicRank {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try
        {
            FileReader fr=new FileReader("/home/sist/music_data/genie_melon/part-00000");
            int i=0;
            String data="";
            while((i=fr.read())!=-1)
            {
                data+=String.valueOf((char)i);
            }
            fr.close();
            data=data.replace("(", "");
            data=data.replace(")", "");
            String[] datas=data.split("\n");
            String[] titles=new String[datas.length];
            int[] ranks=new int[datas.length];
            int k=0;
            for(String s:datas)
            {
                StringTokenizer st=new StringTokenizer(s, ",");
                String title=st.nextToken();
                int rank1=Integer.parseInt(st.nextToken());
                int rank2=Integer.parseInt(st.nextToken());
                //System.out.println(title+":"+(100-(rank1+rank2)));
                titles[k]=title;
                ranks[k]=(100-(rank1+rank2));
                k++;
            }
            //System.out.println(data);
            for(int j=0;j<titles.length;j++)
            {
                System.out.println(titles[j]+":"+ranks[j]);
            }
            /*
             *         50 45 10 20 30
             *         == ==
             *         45 50 10 20 30
             *         ==    ==
             *         10 50 45 20 30
             *        ==        ==
             *        10 50 45 20 30
             *        ==             ==
             *        10 50 45 20 30
             *        ================================= 1r
             *           50 45 20 30
             */
            /*
            for(int a=0;a<ranks.length-1;a++) // Select Sort 방식 , 테스트 코드의 단골손님이다.
            {
                for(int b=a+1;b<ranks.length;b++)
                {
                    if(ranks[a]<ranks[b])
                    {
                        int temp=ranks[a];
                        ranks[a]=ranks[b];
                        ranks[b]=temp;
                        
                        String str=titles[a];
                        titles[a]=titles[b];
                        titles[b]=str;
                    }
                }
            }
            */
            /*
                Bubble Sort
                45 50 26 30 10
                == ==
                   == ==
                      == ==
                         == ==  4
                45 50 26 30
                == ==
                   == ==
                      == ==        3
                                  2
                                  1
                a  b
                0  4  4  a+b=4 b=4-a
                1  3
                2  2
                3  1
            */
            for(int a=0;a<titles.length-1;a++)
            {
                for(int b=a;b<titles.length-1-a;b++)
                {
                    if(ranks[a]<ranks[b+1])
                    {
                        int temp=ranks[a];
                        ranks[a]=ranks[b+1];
                        ranks[b+1]=temp;
                        
                        String str=titles[a];
                        titles[a]=titles[b+1];
                        titles[b+1]=str;
                    }
                }
            }
            System.out.println("정렬후.....");
            
            
            for(int j=0;j<titles.length;j++)
            {
                System.out.println(titles[j]+":"+(j+1));
            }
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
} 
 