package com.amiya.mt;

public class CharactersData {
    private final String name;
    private final int hp;
    private final String namePath;
    private final String backgroundPath;

    public CharactersData(String name,int hp,String namePath,String backgroundPath){
        this.name=name;
        this.hp=hp;
        this.namePath=namePath;
        this.backgroundPath=backgroundPath;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public String getNamePath() {
        return namePath;
    }

    public String getBackgroundPath() {
        return backgroundPath;
    }
}
