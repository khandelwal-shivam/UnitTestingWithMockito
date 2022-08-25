package test.Unit_test_Without_Mockito.dummy_test_double_example.Service;

import Unit_Testing_Without_Mockito.dummy_test_double_example.Service.EmailService;

public class DummyEmailService implements EmailService {

    @Override
    public void sendEmail() {
        throw new AssertionError("Method not implemented!!!");
    }
}
