/*

import com.example.dao.GameMapper;
import com.example.pojo.Game;
import com.example.pojo.Staff;
import com.example.service.GameService;
import com.example.service.StaffService;
import com.example.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class StaffController {
    @Resource
    private StaffService staffService;

    @Resource
    private GameService GameService;
    @Resource
    private GameMapper GameMapper;

    @GetMapping("/staff")
    public String list() {
        return "admin/staff-list";
    }

    @GetMapping("/staff/listall")
    @ResponseBody
    public Result listAll(@RequestParam Map<String, Object> params) {
        int page = Integer.parseInt(params.get("page").toString());
        int limit = Integer.parseInt(params.get("limit").toString());
        int start = (page - 1) * limit;
        return staffService.getStaffsList(start, limit);
    }

    @GetMapping("/staff/view")
    public String staffView(@RequestParam Integer id, Model model) {
        Staff staff = staffService.getStaffById(id);  //查找对应id号的员工信息
        //根据该员工的部门号确定对应的部门
        Game Game = GameService.getGameById(staff.getDepartId());
        staff.setDepartname(Game.getDname()); //把该部门的部门名设置到该员工的部门名属性
        model.addAttribute("staffInfo", staff);
        return "admin/staff-view";
    }

    @GetMapping("/staff/add")
    public String gotoStaffAdd(Model model) {
        String sex[] = {"男", "女"};
        String nation[] = {"汉族", "蒙古族", "回族", "藏族", "维吾尔族", "苗族", "彝族", "壮族", "布依族", "朝鲜族", "满族", "侗族", "瑶族", "白族", "土家族",
                "哈尼族", "哈萨克族", "傣族", "黎族", "傈僳族", "佤族", "畲族", "高山族", "拉祜族", "水族", "东乡族", "纳西族", "景颇族", "柯尔克孜族",
                "土族", "达斡尔族", "仫佬族", "羌族", "布朗族", "撒拉族", "毛南族", "仡佬族", "锡伯族", "阿昌族", "普米族", "塔吉克族", "怒族", "乌孜别克族",
                "俄罗斯族", "鄂温克族", "德昂族", "保安族", "裕固族", "京族", "塔塔尔族", "独龙族", "鄂伦春族", "赫哲族", "门巴族", "珞巴族", "基诺族"};
        String education[] = {"高中及以下", "大专", "本科", "研究生"};
        String degree[] = {"无学位", "学士", "双学士", "硕士", "博士"};
        model.addAttribute("sex", sex);
        model.addAttribute("nation", nation);
        model.addAttribute("education", education);
        model.addAttribute("degree", degree);
        //查找到部门表中第一条到最后一条记录
        model.addAttribute("departs", GameMapper.findGameList(0, GameMapper.getTotalGames()));
        return "admin/staff-add";
    }

    @PostMapping("/staff/add")
    @ResponseBody
    public Result<String> addStaff(@RequestBody Map<String, Object> map) {
        Staff staff = new Staff();
        staff.setSname(map.get("sname").toString());
        staff.setSex(map.get("sex").toString());

        */
/*前端向后端的日期转换---*//*

        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date dayDateSql = null;
        try {
            java.util.Date date = fmt.parse(map.get("birthday").toString());  // 日期字符串转为java.util.Date格式
            dayDateSql = new java.sql.Date(date.getTime());  //java.util.Date格式转为java.sql.Date格式，用于数据库交互
        } catch (ParseException e) {
            e.printStackTrace();
        }
        */
/*---前端向后端的日期转换*//*

        staff.setBirthday(dayDateSql);

        staff.setSid(map.get("sid").toString());
        staff.setDepartId(Integer.parseInt(map.get("depart_id").toString()));

        try {
            java.util.Date date = fmt.parse(map.get("entrydate").toString());
            dayDateSql = new java.sql.Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        staff.setEntrydate(dayDateSql);

        staff.setNation(map.get("nation").toString());
        staff.setNativeplace(map.get("nativeplace").toString());
        staff.setStel(map.get("stel").toString());
        staff.setSemail(map.get("semail").toString());
        staff.setEducation(map.get("education").toString());
        staff.setDegree(map.get("degree").toString());
        staff.setUniversity(map.get("university").toString());
        staff.setMajor(map.get("major").toString());

        try {
            java.util.Date date = fmt.parse(map.get("startdate").toString());
            dayDateSql = new java.sql.Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        staff.setStartdate(dayDateSql);

        try {
            java.util.Date date = fmt.parse(map.get("enddate").toString());
            dayDateSql = new java.sql.Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        staff.setEnddate(dayDateSql);

        if (staff.getEnddate().before(new Date())) {  //如果试用期结束日期在当前日期之前
            staff.setStatus("转正");
        } else {
            staff.setStatus("试用期");
        }
        return staffService.addStaff(staff);
    }

    @GetMapping("/staff/edit")
    public String gotostaffEdit(@RequestParam Integer id, Model model) {
        Staff staff = staffService.getStaffById(id);
        Game Game = GameService.getGameById(staff.getDepartId());
        staff.setDepartname(Game.getDname());
        model.addAttribute("staffInfo", staff);
        String sex[] = {"男", "女"};
        String nation[] = {"汉族", "蒙古族", "回族", "藏族", "维吾尔族", "苗族", "彝族", "壮族", "布依族", "朝鲜族", "满族", "侗族", "瑶族", "白族", "土家族",
                "哈尼族", "哈萨克族", "傣族", "黎族", "傈僳族", "佤族", "畲族", "高山族", "拉祜族", "水族", "东乡族", "纳西族", "景颇族", "柯尔克孜族",
                "土族", "达斡尔族", "仫佬族", "羌族", "布朗族", "撒拉族", "毛南族", "仡佬族", "锡伯族", "阿昌族", "普米族", "塔吉克族", "怒族", "乌孜别克族",
                "俄罗斯族", "鄂温克族", "德昂族", "保安族", "裕固族", "京族", "塔塔尔族", "独龙族", "鄂伦春族", "赫哲族", "门巴族", "珞巴族", "基诺族"};
        String education[] = {"高中及以下", "大专", "本科", "研究生"};
        String degree[] = {"无学位", "学士", "双学士", "硕士", "博士"};
        model.addAttribute("sex", sex);
        model.addAttribute("nation", nation);
        model.addAttribute("education", education);
        model.addAttribute("degree", degree);
        model.addAttribute("departs", GameMapper.findGameList(0, GameMapper.getTotalGames()));
        return "admin/staff-edit";
    }

    @PostMapping("/staff/edit")
    @ResponseBody
    public Result<String> saveStaff(@RequestBody Map<String, Object> map) {
        Staff staff = staffService.getStaffById(Integer.parseInt(map.get("id").toString()));
        staff.setSname(map.get("sname").toString());
        staff.setSex(map.get("sex").toString());

        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date dayDateSql = null;
        try {
            java.util.Date date = fmt.parse(map.get("birthday").toString());
            dayDateSql = new java.sql.Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        staff.setBirthday(dayDateSql);

        staff.setSid(map.get("sid").toString());
        staff.setDepartId(Integer.parseInt(map.get("depart_id").toString()));

        try {
            java.util.Date date = fmt.parse(map.get("entrydate").toString());
            dayDateSql = new java.sql.Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        staff.setEntrydate(dayDateSql);

        staff.setNation(map.get("nation").toString());
        staff.setNativeplace(map.get("nativeplace").toString());
        staff.setStel(map.get("stel").toString());
        staff.setSemail(map.get("semail").toString());
        staff.setEducation(map.get("education").toString());
        staff.setDegree(map.get("degree").toString());
        staff.setUniversity(map.get("university").toString());
        staff.setMajor(map.get("major").toString());

        try {
            java.util.Date date = fmt.parse(map.get("startdate").toString());
            dayDateSql = new java.sql.Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        staff.setStartdate(dayDateSql);

        try {
            java.util.Date date = fmt.parse(map.get("enddate").toString());
            dayDateSql = new java.sql.Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        staff.setEnddate(dayDateSql);

        if (staff.getEnddate().before(new Date())) {
            staff.setStatus("转正");
        } else {
            staff.setStatus("试用期");
        }
        return staffService.saveStaff(staff);
    }
}
*/
