package com.euzl.thanks_diary;

public class MomentData {
    private int date;
    private String thing;

    public MomentData(int date, String thing) {
        this.date = date;
        this.thing = thing;
    }

    // TODO: 2020-04-09 이거 정보 있는것들..? 좀 바꾸자. 그리고 int는 삼가는 게 좋겠음 ㅎ 아니면 int라도 string으로
    public int getDate() {
        return this.date;
    }

    public String getThing() {
        return this.thing;
    }


}
