package day12;

/**
 * @author hongtao
 * @create 2022-04-23-13:55
 * 做成处理流/包装流
 */

public class BufferdeReader_ extends  Reader_ {
    private Reader_ reader_; //属性时Reader_类型

//接受Reader_ 子类对象
    public BufferdeReader_(Reader_ reader_) {
        this.reader_ = reader_;
    }
    //让方法更加灵活，多次读取文件
    public void readFiles(int num){
        for (int i = 0;i<num;i++){
            reader_.read();
        }
    }

    //扩展 readString，批量处理字符串数据
    public void readString(int num){
        for (int i =0;i<num;i++){
            reader_.read();
        }
    }

    @Override
    public void read() {

    }
}
