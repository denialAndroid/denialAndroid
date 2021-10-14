package school.alihamz.assignment2.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "appdata")
public class AppData {
    @PrimaryKey(autoGenerate = true)
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFirstNo() {
        return firstNo;
    }

    public void setFirstNo(int firstNo) {
        this.firstNo = firstNo;
    }

    public int getSecondNo() {
        return secondNo;
    }

    public void setSecondNo(int secondNo) {
        this.secondNo = secondNo;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    int firstNo;
    int secondNo;
    int answer;

    public AppData(int firstNo, int secondNo, int answer) {
        this.firstNo = firstNo;
        this.secondNo = secondNo;
        this.answer = answer;
    }
}