package mx.payclip.assessment.command;

import mx.payclip.assessment.dto.TransactionDto;


import java.io.IOException;
import java.util.Optional;

public class AddCommand extends Command {

    private Integer userId;
    private TransactionDto transaction;

    public AddCommand(Integer userId, TransactionDto transaction) {
        this.userId = userId;
        this.transaction = transaction;
    }

    @Override
    public void execute() throws IOException {
        Optional<TransactionDto> dto = transactionDao.saveTransaction(userId, transaction);
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto.get()));
    }
}
