package test.dummy_test_double_example.Service;

import dummy_test_double_example.Service.EmailService;

public class DummyEmailService implements EmailService {

    @Override
    public void sendEmail() {
        throw new AssertionError("Method not implemented!!!");
    }
}
