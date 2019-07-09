package com.yiyaun.java;

import java.util.Scanner;
public class reservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------欢迎使用订餐系统-------------" );
        int a = 1;
        int i = 0;
        int num1 = 0,
            num2 = 0,
            num3 = 0;


        int []serialNumArr = new int[5];
        int []timeArr = new int[5];
        double total;
        double []moneyArr = new double[5];
        double []totalArr = new double[5];
        String []nameArr = new String[5];
        String []summarize = new String[5];
        String []state = new String[5];
        String []addressArr = new String[5];




        do {
            System.out.println("************************");
            System.out.println("1.我要订餐");
            System.out.println("2.查看餐袋");
            System.out.println("3.签收订单");
            System.out.println("4.删除订单");
            System.out.println("5.我要点赞");
            System.out.println("6.退出系统");
            System.out.println("************************");




            int num = sc.nextInt();
            switch(num){
                case 1:             //我要订餐
                    System.out.println("----我要订餐----");
                    System.out.println("序号      菜名        单价");
                    System.out.println("1        黄焖鸡       20.0");
                    System.out.println("2        过桥米线     15.0");
                    System.out.println("3        重庆小面     18.0");
                    System.out.println("请输入菜品序号:");
                    int serialNum = sc.nextInt();
                    System.out.println("请输入份数:");
                    int copies = sc.nextInt();
                    switch (serialNum){
                        case 1:
                            moneyArr[i] = 20.0 * copies;
                            summarize[i] = "黄焖鸡" + copies + "份";
                            break;
                        case 2:
                            moneyArr[i] = 15.0 * copies;
                            summarize[i] = "过桥米线" + copies + "份";
                            break;
                        case 3:
                            moneyArr[i] = 18.0 * copies;
                            summarize[i] = "重庆小面" + copies + "份";
                            break;

                    }

                    System.out.println("请输入订餐人姓名:");
                    String name = sc.next();
                    nameArr[i] = name;

                    System.out.println("请输入送餐时间(10点至20点整点送餐):");

                    while (true){
                        int time = sc.nextInt();
                        if(time < 10 || time > 20 ){
                            System.out.println("时间有误，请重新输入:");
                            continue;
                        }else{
                            timeArr[i] = time;
                            break;
                        }

                    }

                    System.out.println("请输入订单地址");
                    String adress = sc.next();
                    addressArr[i] = adress;

                    serialNumArr[i] = i + 1;
                    state[i] = "已预订";
                    System.out.println("订餐成功");
                    System.out.println("您订的是:" + summarize[i]);
                    System.out.println("送餐时间:" + timeArr[i] + "点");
                    total = moneyArr[i] + 6;
                    totalArr[i] = total;
                    System.out.println("餐费 " + moneyArr[i] + "元," + "配送费 6元," + "总费用:" + total + "元。");

                    i++;

                    a = getA(sc);

                    break;


                case 2:             //查看餐袋
                    System.out.println("序号    订餐人    餐品信息    送餐地址        总金额     订单状态");
                    for( i = 0;i < nameArr.length;i++){
                        if (nameArr[i] == null)
                            break;
                        System.out.println(serialNumArr[i]+"       "+nameArr[i]+"     "+summarize[i]+"   "+addressArr[i]
                                +"       "+"    "+totalArr[i]+"     "+state[i]);

                    }
                    a = getA(sc);
                    break;


                case 3:             //签收订单
                    System.out.println("请输入要签收的订单序号:");
                    serialNum = sc.nextInt();
                    for (i = 0;i < serialNumArr.length;i++){
                        if(serialNumArr[i] == serialNum && state[i] == "已预订"){
                            state[i] = "已签收";
                            System.out.println("签收成功");
                            break;
                        }else if (serialNumArr[i] == serialNum && state[i] == "已签收"){
                            System.out.println("订单已被签收过了!");
                            break;
                        }
                    }

                    a = getA(sc);
                    break;


                case 4:             //删除订单
                    System.out.println("请输入要删除的订单序号:");
                    serialNum = sc.nextInt();
                    for (i = 0;i < serialNumArr.length;i++){
                        if(serialNumArr[i] == serialNum && state[i] == "已签收"){
                            state[i] = "已删除";
                            System.out.println("订单" + state[i]);
                        }else if(serialNumArr[i] == serialNum &&state[i] == "已预订")
                            System.out.println("订单未签收");

                    }
                    for (int j = 0; j < state.length; j++) {
                        if(state[j] == "已删除"){
                            for (int k = j; k < state.length-1; k++) {

                                nameArr[k] = nameArr[k+1];
                                summarize[k] = summarize[k+1];
                                addressArr[k] =  addressArr[k+1];
                                totalArr[k] = totalArr[k+1];
                                state[k] = state[k+1];

                            }

                        }
                    }
                    a = getA(sc);
                    break;
                case 5:             //我要点赞
                    System.out.println("请输入要点赞的菜品序号");
                    System.out.println("1  黄焖鸡    2  过桥米线    3  重庆小面  ");
                    int d = sc.nextInt();
                    switch (d){
                        case 1:
                            num1++;
                            System.out.println("黄焖鸡 "+ num1 +"赞");
                            break;
                        case 2:
                            num2++;
                            System.out.println("过桥米线 "+ num2 +"赞");
                            break;
                        case 3:
                            num3++;
                            System.out.println("重庆小面 "+ num3 +"赞");
                            break;
                    }
                    a = getA(sc);

                    break;


                case 6:             //退出系统
                    a = 6;
                    System.out.println("感谢使用本系统！");
                    break;

            }



        }while (a!=6);


    }

    private static int getA(Scanner sc) {
        int b;
        for (int i = 0;;i++){
            System.out.println("输入0返回主页面,6退出系统");
            b = sc.nextInt();
            if (0 == b)
                return b;
            else if (6 == b) {
                System.out.println("感谢使用本系统");
                break;
            } else {
                System.out.println("输入数字有误，请重新输入：");

            }

        }

        return b;
    }
}
