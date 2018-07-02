package mx.payclip.assessment.controller;


import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import mx.payclip.assessment.command.*;
import mx.payclip.assessment.dto.TransactionDto;

public class AssessmentController {

    private static final String ADD_COMMAND = "add";
    private static final String LIST_COMMAND = "list";
    private static final String SUM_COMMAND = "sum";

    ObjectMapper mapper = new ObjectMapper();

    public void execute(String params[]) throws IOException {
        if (params.length >= 2) {
            Command command;
            String userId = params[0];
            switch (params[1]) {
                case ADD_COMMAND:
                    TransactionDto transaction;
                    transaction = mapper.readValue(params[2], TransactionDto.class);
                    command = new AddCommand(Integer.parseInt(userId), transaction);
                    break;
                case LIST_COMMAND:
                    command = new ListCommand(Integer.parseInt(userId));
                    break;
                case SUM_COMMAND:
                    command = new SumCommand(Integer.parseInt(userId));
                    break;
                default:
                    String transactionId = params[1];
                    command = new ShowCommand(Integer.parseInt(userId),transactionId);
            }

            command.execute();
        }
    }
}
