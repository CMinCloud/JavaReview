package group;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Author：CM
 * @Package：group
 * @Project：JavaReview
 * @name：Grade
 * @Date：2023/5/7 14:55
 * @Filename：Grade
 */
public class Grade {

    private String stuNo;

    private String stuName;

    private String stuClass;

    private Double chineseScore;

    private Double mathScore;

    private Double englishScore;

    private Double avg;


    public Grade(String stuNo, String stuName, String stuClass, Double chineseScore, Double mathScore, Double englishScore) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuClass = stuClass;
        this.chineseScore = chineseScore;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
        /*使用BigDecimal进行精度计算*/
        this.avg = BigDecimal.valueOf(chineseScore)
                .add(BigDecimal.valueOf(mathScore))
                .add(BigDecimal.valueOf(englishScore))
                .divide(BigDecimal.valueOf(3), 2, RoundingMode.HALF_UP).doubleValue();
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public Double getChineseScore() {
        return chineseScore;
    }

    public void setChineseScore(Double chineseScore) {
        this.chineseScore = chineseScore;
    }

    public Double getMathScore() {
        return mathScore;
    }

    public void setMathScore(Double mathScore) {
        this.mathScore = mathScore;
    }

    public Double getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(Double englishScore) {
        this.englishScore = englishScore;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }


    @Override
    public String toString() {
        return "Grade{" +
                "stuNo='" + stuNo + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuClass='" + stuClass + '\'' +
                ", chineseScore=" + chineseScore +
                ", mathScore=" + mathScore +
                ", englishScore=" + englishScore +
                ", avg=" + avg +
                '}';
    }
}
