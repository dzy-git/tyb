package com.example.tyb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zy.duan
 * @since 2021-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("index_book")
public class IndexBook implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String level;

    private Integer time;

    private String bookImg;

    private String direction;

    private String teacher;

    private Integer price;

    private Integer studentNum;

    private Integer rate;

    private Integer knowledgePointNum;

    /**
     * 1 入门课程 2最新课程 3免费课程 推荐课程
     */
    private Integer status;


    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String LEVEL = "level";

    public static final String TIME = "time";

    public static final String BOOK_IMG = "book_img";

    public static final String DIRECTION = "direction";

    public static final String TEACHER = "teacher";

    public static final String PRICE = "price";

    public static final String STUDENT_NUM = "student_num";

    public static final String RATE = "rate";

    public static final String KNOWLEDGE_POINT_NUM = "knowledge_point_num";

    public static final String STATUS = "status";

}
