package com.natsucloud.ktpark.entity;

import com.natsucloud.common.mybatis.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author moqishu
 * @since 2020-04-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_carcome")
@ApiModel(value="Carcome对象", description="")
public class Carcome extends BaseEntity {

private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "摄象机id")
    @TableField("caremaId")
    private Integer caremaId;

    @ApiModelProperty(value = "流水号")
    @TableField("carSerial")
    private String carSerial;

    @ApiModelProperty(value = "图片名称")
    @TableField("imgName")
    private String imgName;

    @ApiModelProperty(value = "车牌号码")
    @TableField("carPlateNum")
    private String carPlateNum;

    @ApiModelProperty(value = "保存多识别结果")
    @TableField("MultiRecog")
    private String MultiRecog;

    @ApiModelProperty(value = "识别正则表达式")
    @TableField("RecogRegex")
    private String RecogRegex;

    @ApiModelProperty(value = "入车时间")
    @TableField("comeTime")
    private LocalDateTime comeTime;

    @ApiModelProperty(value = "流水类型(0:无卡,1:有卡,2:故障（包含强制关闸出现的图片上传）,3:人工要求上传,4:无卡+强制开闸,5:有卡+强制开闸)6:找车系统主动上传,7:找车系统人工抓拍,8:刚进车发送的图片")
    @TableField("serialType")
    private Integer serialType;

    @ApiModelProperty(value = "车颜色")
    @TableField("carColor")
    private String carColor;

    @ApiModelProperty(value = "车标牌")
    @TableField("carBrand")
    private String carBrand;

    @ApiModelProperty(value = "识别可信度")
    @TableField("recogEnable")
    private String recogEnable;

    @ApiModelProperty(value = "ETC卡号")
    @TableField("etcNo")
    private String etcNo;

    @ApiModelProperty(value = "该车牌出现的次数")
    @TableField("carplateCount")
    private Integer carplateCount;

    @TableField("carplateColor")
    private String carplateColor;

    @ApiModelProperty(value = "不带汉字的车牌")
    @TableField("carPlateASI")
    private String carPlateASI;

    @ApiModelProperty(value = "0临时车，1 VIP ，2月租， 3充值，4时租（上班族），5产权车， 6计数车牌")
    @TableField("carType")
    private Integer carType;

    @ApiModelProperty(value = "描述(用来记录固定车设置为临时车的标志)")
    @TableField("Remark")
    private String Remark;

    @ApiModelProperty(value = "上传日期")
    @TableField("CliDate")
    private LocalDateTime CliDate;

    @ApiModelProperty(value = "拍照表ID")
    @TableField("CapImageId")
    private Integer CapImageId;

    @ApiModelProperty(value = "上传标志(0未上传；1上传中；2上传成功；3已回写)")
    @TableField("CliFlag")
    private Integer CliFlag;

    @ApiModelProperty(value = "车辆是否被锁定:0否1是")
    @TableField("IsLock")
    private Integer IsLock;

    @ApiModelProperty(value = "是否置后付费")
    @TableField("SendToBack")
    private Integer SendToBack;

    @ApiModelProperty(value = "后付费车辆最高限额")
    @TableField("BackPayMaxMoney")
    private Integer BackPayMaxMoney;

    @ApiModelProperty(value = "0正常限额；1部分支付，超过部分车场收费")
    @TableField("BackPayType")
    private Integer BackPayType;

    @ApiModelProperty(value = "给标准版用的参数：后付费用类型|")
    @TableField("ExtParm1")
    private String ExtParm1;

    @ApiModelProperty(value = "非标扩展参数：未定义|未定义")
    @TableField("ExtParm2")
    private String ExtParm2;

    @ApiModelProperty(value = "车型关联表t_types的typeValue")
    @TableField("carStyle")
    private Integer carStyle;

    @ApiModelProperty(value = "是否来自在场历史数据还原:0 否,1 是")
    @TableField("IsBak")
    private Integer IsBak;

    @TableField("ClientUpdateTime")
    private LocalDateTime ClientUpdateTime;


}
