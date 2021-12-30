package com.company;

import java.util.Random;

public class Main {
    public static int [] heroesHealth = {170, 130, 180, 125};
    public static int [] heroesDamage = {30, 45, 39, 0};
    public static int medicsHealing = (int) (Math.random()*350);
    public static String[] attackType = {"Physical", "Magical","Aura","Healing"};
    public static String[] heroesNames = {"Warrior", "Mage", "Damage dealer", "Medic"};
    public static int demonLordHealth = 666;
    public static int demonLordDamage = (int) (Math.random()*90);
    public static String demonLordDefence ="";
    public static int roundNum = 1;


    public static void demonDefType(){
        Random random = new Random(); //1:48:03
        int ranIndex = random.nextInt(attackType.length);
        demonLordDefence = attackType[ranIndex];
        System.out.println("demon choose " + demonLordDefence);
    }

    public static void main(String[] args) {
        Statistics();
        while (!Finishing()){
            round();
        }


    }
    public static void round(){
        roundNum ++;
        demonDefType();
        demonHit();
        heroesHit();
        Statistics();

    }

    public static void demonHit(){
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[3] == 0){
                medicsHealing = 1;
            }
            if (demonLordDefence == attackType[3]){
                demonLordHealth = demonLordHealth + medicsHealing;
            }
            if (heroesHealth[i] >0) {
                if (heroesHealth[i] < demonLordDamage){
                    heroesHealth[i] = 0;
                }else {
                    heroesHealth[i] = heroesHealth[i] - demonLordDamage;
                }
            }

        }
    }  public static void heroesHit() {
        if (heroesHealth[3] > -1) {
            heroesHealth[3] = heroesHealth[3] + (medicsHealing =0);
        }

        for (int i = 0; i < heroesDamage.length; i++) {
            if (heroesHealth[i] > 0 && demonLordHealth > 0) {

                if (demonLordDefence == attackType[i]) {
                    Random random = new Random();
                    int c = random.nextInt(10)+2;
                    if (demonLordHealth < heroesDamage[i] * c) {
                        demonLordHealth = 0;
                    } else {
                        demonLordHealth = demonLordHealth - heroesDamage[i] * c;

                    }

                    System.out.println("critical damage " + heroesDamage[i] * c);
                } else {
                    if (heroesHealth[3] == 0){
                        medicsHealing = 0;
                    }
                    if (heroesHealth[i] < 100){
                        heroesHealth[i] = heroesHealth[i] + medicsHealing;

                    }

                    if (demonLordHealth < heroesDamage[i]) {
                        demonLordHealth = 0;
                    } else {
                        demonLordHealth = demonLordHealth - heroesDamage[i];

                    }
                }

            }
        }
    }
    public static boolean Finishing() {
        if (demonLordHealth <= 0){
            System.out.println("heroes won!!!");
            return true;
        }
        boolean heroesDeath = true;
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] >0 ){
                heroesDeath = false;
                break;
            }

        } if (heroesDeath){
            System.out.println("Demon lord win!!!");

        }return heroesDeath;
       /* if (heroesHealth [0] <= 0 && heroesHealth [1] <= 0 && heroesHealth [2] <= 0 && heroesHealth [3] <= 0){
            System.out.println("Demon Lord Win!!!");
            return true;
        }
        return  false;*/ //так делать нельзя!!!!!!!!!!!!!!

    }
    public static void Statistics(){
        System.out.println( roundNum + " Round __________________________________________________________");
        System.out.println("Boss Health: " + demonLordHealth + " [" + demonLordDamage + "] ");
        for (int i = 0; i < heroesHealth.length; i++) {
            System.out.println(heroesNames [i] + "'s health: " + heroesHealth[i] + " [" + heroesDamage[i] + "] ");

        }
        System.out.println();

    }
}
