package Worksheet.Q7;

class CustomResource2 implements AutoCloseable {
    @Override
    public void close() throws Exception {
        throw new Exception("Exception from CustomResource2 close()");
    }
}
