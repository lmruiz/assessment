package mx.payclip.assessment.command;

import mx.payclip.assessment.dto.TransactionDto;

import java.io.IOException;
import java.util.Optional;

public class ShowCommand extends Command {
    private Integer userId;
    private String transactionId;

    public ShowCommand(Integer userId, String transactionId) {
        this.userId = userId;
        this.transactionId = transactionId;
    }

    @Override
    public void execute() throws IOException {
        Optional<TransactionDto> transactionDto = transactionDao.findByUserIdAndTransactionId(userId, transactionId);
        if(transactionDto.isPresent()){
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(transactionDto.get()));
        }else{
            System.out.println("Transaction Not Found");
        }
    }
}
