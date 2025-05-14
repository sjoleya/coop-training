package Worksheet.Q7;

class CustomResource1 implements AutoCloseable {
    @Override
    public void close() throws Exception {
        throw new Exception("Exception from CustomResource1 close()");
    }
}
