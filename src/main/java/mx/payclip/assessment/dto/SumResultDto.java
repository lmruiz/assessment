package mx.payclip.assessment.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class SumResultDto {
    @JsonProperty("user_id")
    private Integer userId;

    private BigDecimal sum;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
}
