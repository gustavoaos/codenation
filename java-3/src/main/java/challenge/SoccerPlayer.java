package challenge;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import com.opencsv.bean.CsvNumber;

import java.util.Date;
import java.util.Objects;

public class SoccerPlayer {

    @CsvBindByName(column="ID", required=true)
    private int id;

    @CsvBindByName
    private String nationality;

    @CsvBindByName
    private String club;

    @CsvBindByName(column="full_name", required=true)
    private String fullName;

    @CsvBindByName(column="eur_release_clause", required=false)
    @CsvNumber(value = "#")
    private int eurReleaseClause;

    @CsvBindByName(column="eur_wage", required=true)
    @CsvNumber(value = "#")
    private int eurWage;

    @CsvBindByName(column="birth_date", required=true)
    @CsvDate("yyyy-MM-dd")
    private Date birthDate;

    @CsvBindByName
    private int age;
    

    public SoccerPlayer() {
    }

    public SoccerPlayer(int id, String nationality, String club, String fullName, int eurReleaseClause, int eurWage, Date birthDate, int age) {
        this.id = id;
        this.nationality = nationality;
        this.club = club;
        this.fullName = fullName;
        this.eurReleaseClause = eurReleaseClause;
        this.eurWage = eurWage;
        this.birthDate = birthDate;
        this.age = age;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getClub() {
        return this.club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getEurReleaseClause() {
        return this.eurReleaseClause;
    }

    public void setEurReleaseClause(int eurReleaseClause) {
        this.eurReleaseClause = eurReleaseClause;
    }

    public int getEurWage() {
        return this.eurWage;
    }

    public void setEurWage(int eurWage) {
        this.eurWage = eurWage;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SoccerPlayer)) {
            return false;
        }
        SoccerPlayer soccerPlayer = (SoccerPlayer) o;
        return id == soccerPlayer.id && Objects.equals(nationality, soccerPlayer.nationality) && Objects.equals(club, soccerPlayer.club) && Objects.equals(fullName, soccerPlayer.fullName) && eurReleaseClause == soccerPlayer.eurReleaseClause && eurWage == soccerPlayer.eurWage && Objects.equals(birthDate, soccerPlayer.birthDate) && age == soccerPlayer.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nationality, club, fullName, eurReleaseClause, eurWage, birthDate, age);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nationality='" + getNationality() + "'" +
            ", club='" + getClub() + "'" +
            ", fullName='" + getFullName() + "'" +
            ", eurReleaseClause='" + getEurReleaseClause() + "'" +
            ", eurWage='" + getEurWage() + "'" +
            ", birthDate='" + getBirthDate() + "'" +
            ", age='" + getAge() + "'" +
            "}";
    }
    

}