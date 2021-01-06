package com.example.tyb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("student_book")
public class StudentBook implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "book_id", type = IdType.AUTO)
    private Integer bookId;

    private Integer id;

    private Integer time;

    private String teacher;

    private Integer price;

    private String url;

    private Integer studentNum;

    private String bookImg;

    private String direction;

    private Integer knowledgePointNum;

    private String name;

    private String level;


    public static final String BOOK_ID = "book_id";

    public static final String ID = "id";

    public static final String TIME = "time";

    public static final String TEACHER = "teacher";

    public static final String PRICE = "price";

    public static final String URL = "url";

    public static final String STUDENT_NUM = "student_num";

    public static final String BOOK_IMG = "book_img";

    public static final String DIRECTION = "direction";

    public static final String KNOWLEDGE_POINT_NUM = "knowledge_point_num";

    public static final String NAME = "name";

    public static final String LEVEL = "level";

}
