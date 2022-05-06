package day12;

/**
 * @author hongtao
 * @create 2022-04-23-13:58
 */

public class Text_ {
    public static void main(String[] args) {
        BufferdeReader_ bufferdeReader_  = new BufferdeReader_(new FileReader_());
        bufferdeReader_.readFiles(10);

        //希望BufferdeReader_多次读取字符串

        BufferdeReader_ bufferdeReader_1 = new BufferdeReader_(new StringReader_());
        bufferdeReader_1.readString(10);


    }
}
