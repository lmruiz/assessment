package mx.payclip.assessment.command;

import mx.payclip.assessment.dto.SumResultDto;

import java.io.IOException;

public class SumCommand extends Command {

    private Integer userId;


    public SumCommand(Integer userId) {
        this.userId = userId;
    }

    @Override
    public void execute() throws IOException {
        SumResultDto sumResultDto = transactionDao.sumAllByUserId(userId);

        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(sumResultDto));
    }
}
