package mx.payclip.assessment.command;

import mx.payclip.assessment.dto.TransactionDto;

import java.io.IOException;
import java.util.List;

public class ListCommand extends Command {

    private Integer userId;

    public ListCommand(Integer userId) {
        this.userId = userId;
    }

    @Override
    public void execute() throws IOException {
        List<TransactionDto> dtoList = transactionDao.findAllByUserId(userId);
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dtoList));
    }
}
