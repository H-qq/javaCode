package pro.service;

import pro.domain.Archietect;
import pro.domain.Designer;
import pro.domain.Employee;
import pro.domain.Programmer;

public class TeamService {
    private static  int counter = 1;  //给numberID 赋值递增
    private final int MAX_MEMER = 5; //限制人数
    private Programmer[] team = new Programmer[MAX_MEMER];//保存开发团队人员
    private int total;//记录开发团队中实际的人数

    public  TeamService(){
        super();
    }
    //获取开发团队人员
    public Programmer[] getTeam(){
        Programmer[] team = new Programmer[total];
        for(int i = 0;i<team.length;i++){
            team[i] = this.team[i];
        }
        return team;
    }
    //将指定员工添加到团队人员
    public void addMenber(Employee e) throws TemException{
        //成员已满无法添加
        if (total>= MAX_MEMER){
            throw new TemException("成员已满无法添加");
        }
        //该人员不是开发人员，无法添加
        if (!(e instanceof Programmer)){
            throw new TemException("该人员不是开发人员，无法添加");
        }
        //该人员已经存在
        if (isExist(e)){
            throw new TemException("该人员已经存在");
        }
        //该员工已经是某团队人员或者休假
        Programmer p = (Programmer) e;
        if ("BUSY".equals(p.getStatus().getNAME())){
            throw new TemException("已经是某团队人员");
        }else if("VOCATION".equals(p.getStatus().getNAME())){
            throw new TemException("该员工正在休假");
        }
        //团队中最多只有一个架构师
        //首先获取中Team已有成员中的架构师、设计师、程序员
        int numOfArch = 0,numOfDes = 0,numOfpro = 0;
        for (int i =0 ;i<total;i++){
            if (team[i] instanceof Archietect){
                numOfArch++;
            }else if (team[i] instanceof Designer){
                numOfDes++;
            }else if (team[i] instanceof Programmer){
                numOfpro++;
            }
        }
        if (p instanceof Archietect){
            if (numOfArch>=1){
                throw new TemException("团队中最多只能有一名架构师");
            }else if (p instanceof Designer){
                if (numOfDes>=2){
                    throw new TemException("团队中最多只能有两名设计师");
                }
            }else if (p instanceof Programmer){
                if (numOfpro>=3){
                    throw new TemException("该团队中最多只能有三名程序员");
                }
            }


        }
        //将p 添加到现有的team中
        team[total++] = p;
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
    }

    private boolean isExist(Employee e) {
        for (int i = 0;i<total;i++){
            if (team[i].getId() == e.getId()){
                return true;
            }
        }
        return false;
    }

    public void renmoveMenber(int menberID) throws TemException {
        int i = 0;
        for (; i < total; i++) {
            if (team[i].getMemberId() == menberID) {
                team[i].setStatus(Status.FREE);
                break;
            }
        }

        if (i == total) {
            throw new TemException("未找到员工，删除失败");
        }


        for (int j = i; j < total - 1; j++) {
            team[j] = team[j + 1];
        }
        team[total - 1] = null;
        total--;
        //未找到指定menID
    }
    }

