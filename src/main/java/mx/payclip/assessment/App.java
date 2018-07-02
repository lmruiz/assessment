package mx.payclip.assessment;

import mx.payclip.assessment.controller.AssessmentController;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        AssessmentController assessmentController = new AssessmentController();
        assessmentController.execute(args);
    }
}
