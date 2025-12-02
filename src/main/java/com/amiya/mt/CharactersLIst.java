package com.amiya.mt;

public enum CharactersLIst {
    STEVE(new CharactersData("史蒂夫",100,"steve.png","steve_background.png"));

    private CharactersData charactersData;

    CharactersLIst(CharactersData charactersData){
        this.charactersData=charactersData;
    }

    public CharactersData getCharactersData() {
        return charactersData;
    }

}
