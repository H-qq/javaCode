package pro.service;
//自定义异常类
public class TemException extends  Exception{
    static final long serialVersionUID = -3387516991248L;

    public TemException(){
        super();
    }
    public TemException(String msg){
        super(msg);
    }
}
