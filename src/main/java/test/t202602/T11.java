package test.t202602;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import com.yh.infra.common.exception.BusinessException;
import com.yonghui.common.config.ConfigManager;
import com.yonghui.common.constants.PayModeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.com.yonghui.common.exception.BaseKnownException;
import javax.com.yonghui.common.exception.common.BadParameterException;
import javax.com.yonghui.common.exception.log.ExceptionLogger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class T11 {

    public static void main(String[] args) {
        String sss = "sss";
        sss=sss+"sass";
        System.out.println(sss);
    }
}


package com.yonghui.risk.hub.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import com.yh.infra.common.exception.BusinessException;
import com.yonghui.anti.cheat.service4j.facade.RiskService;
import com.yonghui.anti.cheat.service4j.facade.vo.SearchRequestVO;
import com.yonghui.common.config.ConfigManager;
import com.yonghui.common.constants.PayModeEnum;
import com.yonghui.common.util.DateUtil;
import com.yonghui.common.util.StringUtil;
import com.yonghui.membercenter.api.IMemberService;
import com.yonghui.membercenter.dto.response.Response;
import com.yonghui.membercenter.model.entity.MemberMobile;
import com.yonghui.membercenter.model.entity.YhMember;
import com.yonghui.membercenter.model.enumeration.MemberState;
import com.yonghui.mvc.gateway.OpenAPI;
import com.yonghui.mvc.gateway.ProductType;
import com.yonghui.risk.api.RiskInfoService;
import com.yonghui.risk.api.RiskOperationService;
import com.yonghui.risk.api.RiskPayInfoService;
import com.yonghui.risk.api.security.RiskControlService;
import com.yonghui.risk.api.security.model.RiskControlResponse;
import com.yonghui.risk.core.api.*;
        import com.yonghui.risk.core.model.*;
        import com.yonghui.risk.core.model.dto.RiskHistoryInfoDto;
import com.yonghui.risk.core.model.GetSimilarPicRequestDto;
import com.yonghui.risk.core.model.GetSimilarPicResponseVO;
import com.yonghui.risk.core.model.RiskCoreResponse;
import com.yonghui.risk.core.model.YhRiskFingerPrintMemberDto;
import com.yonghui.risk.enums.AlgorithmRiskLevelEnum;
import com.yonghui.risk.hub.api.PicService;
import com.yonghui.risk.hub.constants.RiskHubConstants;
import com.yonghui.risk.hub.dto.UserScoreResp;
import com.yonghui.risk.hub.enums.*;
        import com.yonghui.risk.hub.helper.UserHelper;
import com.yonghui.risk.hub.response.YhResponse;
import com.yonghui.risk.hub.service.ApplyProcessService;
import com.yonghui.risk.hub.service.impl.UserScoreService;
import com.yonghui.risk.hub.util.*;
        import com.yonghui.risk.hub.util.log.MethodAroundLog;
import com.yonghui.risk.hub.vo.*;
        import com.yonghui.risk.manage.configuration.service.ConfigurationManageClient;
import com.yonghui.risk.model.*;
        import com.yonghui.risk.model.dto.RiskEngineRuleDeleteDto;
import com.yonghui.risk.model.entity.RiskPageEntity;
import com.yonghui.risk.model.entity.YhRiskFingerPrintMember;
import com.yonghui.risk.user.relation.model.dto.RiskApplyQueryDto;
import com.yonghui.risk.user.relation.model.vo.RiskApplyQueryResultVo;
import com.yonghui.risk.user.relation.service.RiskApplyQueryService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
        import org.springframework.web.multipart.MultipartFile;

import javax.com.yonghui.common.exception.BaseKnownException;
import javax.com.yonghui.common.exception.common.BadParameterException;
import javax.com.yonghui.common.exception.log.ExceptionLogger;
import javax.validation.Valid;
import java.util.*;
        import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@Slf4j
@RequestMapping("/risk")
public class RiskController {

    private static Logger logger = LoggerFactory.getLogger(RiskController.class);

    @Autowired
    private RiskControlService riskControlService;
    @Autowired
    private RiskCoreControlManageService riskCoreControlManageService;
    @Autowired
    private RiskInfoService riskInfoService;
    @Autowired
    private RiskCoreFingerPrintMemberService riskCoreFingerPrintMemberService;
    @Autowired
    private ApplyProcessService applyProcessService;
    @Autowired
    private RiskOperationService riskOperationService;
    @Autowired
    private RiskPayInfoService riskPayInfoService;
    @Autowired
    private RiskCoreOrderPayIdentityService riskCoreOrderPayIdentityService;
    @Autowired
    private RiskCoreControlOperationHistoryService riskCoreControlOperationHistoryService;
    @Autowired
    private IMemberService memberService;
    @Autowired
    private RiskService antiRiskService;
    @Autowired
    private RiskCoreEngineService riskCoreEngineService;

    @Autowired
    private PicService picService;

    @Autowired
    private UserHelper userHelper;

    @Autowired
    private ConfigurationManageClient configurationManageClient;
    @Autowired
    private RiskCorePayLocksService riskCorePayLocksService;

    @Autowired
    private RiskApplyQueryService riskApplyQueryService;

    @Autowired
    private UserScoreService userScoreService;

    public static final String JURISDICTION_0002 = "JURISDICTION_0002";

    public static final String JURISDICTION_0003 = "JURISDICTION_0003";

    /**
     * 黄牛算法标识
     */
    public static final String TOUT_MARK = "SAMPLE_PEOPLE";
    public static final String RISK_ORDER_CATTLE_SCORE_RANGE = "risk-order-cattle-score-range";
    public static final String ORDER_CATTLE_SCORE_RANGE = "60,90";

    @ApiOperation("校验手机号 0 成功，1 非会员，2 无风控记录")
    @GetMapping(value = "/validMember", produces = "application/json;charset=UTF-8")
    @OpenAPI(products = {ProductType.ALLIEDWEB}, authorities = {"yhcrm:risk:black:valid"})
    @ResponseBody
    @MethodAroundLog(remark = "校验手机号")
    public String validMember(@RequestParam(value = "mobile", required = false) String mobile) {
        String result = CommonConstants.RESPONSE_SUCCESS_VALID_MOBILE;
        boolean flag = riskControlService.isValidMember(mobile);
        if (flag) {
            RiskOperationHistoryResp resp = riskInfoService.getOperationHistoryByMobile(mobile);
            List<RiskOperationHistoryResp.RiskOperationHistoryDetailResp> historyDetailResps =
                    filterInnerWhite(resp.getDetails());
            if (CollectionUtils.isEmpty(historyDetailResps)) {
                result = CommonConstants.RESPONSE_NO_RISK_VALID_MOBILE;
//				result =  CommonConstants.RESPONSE_SUCCESS_VALID_MOBILE;
            }
        } else {
            result = CommonConstants.RESPONSE_NOT_MEMBER_VALID_MOBILE;
        }
        return result;
    }

    @ApiOperation("校验手机号 0 成功，1 非会员，2 无风控记录（文件批量导入）")
    @PostMapping(value = "/batchValidMember")
    @OpenAPI(products = {ProductType.ALLIEDWEB}, authorities = {"yhcrm:risk:black:valid:batch"})
    @ResponseBody
    @MethodAroundLog(remark = "批量校验手机号")
    public BatchValidBlackAddResp batchValidMember(
            @RequestParam(value = "file") MultipartFile file) {
        List<String> mobiles = parseExcelFile(file);
        if (CollectionUtils.isEmpty(mobiles)) {
            throw new BaseKnownException(400003, "excel内的手机号不能为空");
        }
        BatchValidBlackAddResp batchValidBlackAddResp = new BatchValidBlackAddResp();
        mobiles.stream().forEach(mobile -> {
            boolean flag = riskControlService.isValidMember(mobile);
            if (flag) {
                batchValidBlackAddResp.getAvailableMobiles().add(mobile);
            } else {
                batchValidBlackAddResp.getErrorMobiles().add(mobile);
            }
        });
        if(CollectionUtils.isNotEmpty(batchValidBlackAddResp.getAvailableMobiles())){
            batchValidBlackAddResp.setAvailableCount(batchValidBlackAddResp.getAvailableMobiles().size());
        }
        return batchValidBlackAddResp;
    }

    private List<RiskOperationHistoryResp.RiskOperationHistoryDetailResp> filterInnerWhite(List<RiskOperationHistoryResp.RiskOperationHistoryDetailResp> details) {
        return details.stream()
                .filter(vo -> null != vo)
                .filter(vo -> RiskOperationDisplayEnum.INNERUNLOCK.getValue() != vo.getOperation())
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "保存黑名单", notes = "异常描述200001,200003")
    @PostMapping(value = "/create")
    @OpenAPI(products = {ProductType.ALLIEDWEB}, authorities = {"yhcrm:risk:black:addblack"})
    @ResponseBody
    @MethodAroundLog(remark = "保存黑名单")
    public String saveBlacklist(@RequestBody BlackAddVO blackAddVO) {
        String user = getCurrentUser();
        riskOperationService.addToBlack(blackAddVO.buildRiskBlackReq(user));
        return CommonConstants.RESPONSE_SUCCESS;
    }

    @ApiOperation(value = "批量保存黑名单", notes = "异常描述200001,200003")
    @PostMapping(value = "/batchCreate")
    @OpenAPI(products = {ProductType.ALLIEDWEB}, authorities = {"yhcrm:risk:black:batchaddblack"})
    @ResponseBody
    @MethodAroundLog(remark = "批量保存黑名单")
    public BatchSaveBlackAddResp batchSaveBlacklist(@RequestBody BatchBlackAddVO batchBlackAddVO) {
        if (CollectionUtils.isEmpty(batchBlackAddVO.getMobiles())) {
            throw ErrorCodeEnum.ERROR_CODE_MOBILE_CANNOT_EMPTY.buildBaseKnownException();
        }

        BatchSaveBlackAddResp batchSaveBlackAddResp = new BatchSaveBlackAddResp();
        for (String mobile : batchBlackAddVO.getMobiles()) {
            String user = getCurrentUser();
            RiskBlackReq riskBlackReq = batchBlackAddVO.buildRiskBlackReq(mobile, user);
            try {
                riskOperationService.addToBlack(riskBlackReq);
            } catch (RuntimeException e) {
                batchSaveBlackAddResp.getExistMobiles().add(mobile);
                continue;
            }
            batchSaveBlackAddResp.getSuccessMobiles().add(mobile);
        }
        return batchSaveBlackAddResp;
    }


    @ApiOperation("查询风险用户信息,可能的异常200001,200003")
    @GetMapping(value = "/summary/query")
    @OpenAPI(products = {ProductType.ALLIEDWEB}, authorities = {"yhcrm:risk:black:summery"})
    @ResponseBody
    @MethodAroundLog(remark = "查询风险用户信息")
    public RiskSummaryResponseVO getRiskSummaryInfo(@RequestParam(value = "mobile", required = false) String mobile) {
        YhMember yhMember = memberService.getMemberByMobile(mobile);
        if(Objects.isNull(yhMember)){
            RiskSummaryResponseVO responseVO = new RiskSummaryResponseVO();
            return responseVO;
        }
        Long memberId = yhMember.getId();
        if (DiamondConfigUtils.getSwitchOn(DiamondConfigEnum.RISK_CENTER_APPLY_SWITCH)) {
            //查询拉黑信息
            RiskBlackResp riskBlackResp = riskInfoService.getRiskBlackByMobile(mobile);
            RiskSummaryResponseVO responseVO = new RiskSummaryResponseVO(riskBlackResp);
            return responseVO;
        } else {
            String userType = "普通用户";
            int payLockNum = Optional.ofNullable(riskCoreControlOperationHistoryService.countPayLockHistory(mobile))
                    .filter(RiskCoreResponse::isOk)
                    .map(RiskCoreResponse::getResult)
                    .orElseThrow(() -> new BaseKnownException(1, "没有查询到锁定记录数"));
            //设备指纹号（以最后登录的设备为准）
            String deviceFingerprint = "";
            //手机号关联的设备指纹个数
            int deviceFingerprintCount = 0;
            //指纹设备关联的手机号
            List<String> deviceFingerprintRelationMobile = new ArrayList<>();
            //風險等級描述
            String riskLevelDescription = "";
            if(memberId != null){
                //風險等級描述
                riskLevelDescription = getRiskLevelDescription(mobile, memberId);
                //設備指紋數量
                deviceFingerprintCount = Optional.ofNullable(riskCoreFingerPrintMemberService.selectDistinctFingerPrintByMemberId(memberId))
                        .filter(RiskCoreResponse::isOk)
                        .map(RiskCoreResponse::getResult)
                        .orElse(Lists.newArrayList())
                        .size();

                //获取最新设备指纹号
                final YhRiskFingerPrintMemberDto fingerprintInfo = Optional.ofNullable(
                                riskCoreFingerPrintMemberService.getLatestFingerprintInfo(memberId))
                        .filter(s -> s.isOk() && s.getResult() != null)
                        .map(RiskCoreResponse::getResult)
                        .orElse(null);
                if (null != fingerprintInfo) {
                    deviceFingerprint = fingerprintInfo.getFingerPrint();
                    final List<Long> memberIds =
                            Optional.ofNullable(riskCoreFingerPrintMemberService.selectMemberIdsByFingerPrints(Lists.newArrayList(deviceFingerprint), "DESC", 50))
                                    .filter(RiskCoreResponse::isOk)
                                    .map(RiskCoreResponse::getResult)
                                    .orElse(Lists.newArrayList());
                    deviceFingerprintRelationMobile = Optional.ofNullable(memberService.queryMemberInfoByMemberIds(memberIds))
                            .orElse(Lists.newArrayList())
                            .stream()
                            .map(MemberMobile::getMobile)
                            .collect(Collectors.toList());

                }
            }
            RiskSummaryResponseVO riskSummaryResponseVO = new RiskSummaryResponseVO(RiskBlackResp.builder()
                    .deviceFingerprintCount(deviceFingerprintCount)
                    .riskLevelDescription(riskLevelDescription)
                    .deviceFingerprintRelationMobile(deviceFingerprintRelationMobile)
                    .mobile(mobile)
                    .userType(userType)
                    .blackNumber(0)
                    .lockNumber(payLockNum).build());

            //处理风险图谱数据
            try {
                if (memberId != null) {
                    RiskApplyQueryDto riskApplyQueryDto = new RiskApplyQueryDto();
                    riskApplyQueryDto.setMemberId(String.valueOf(memberId));
                    riskApplyQueryDto.setReceivePhone(String.valueOf(mobile));
                    RiskApplyQueryResultVo query = riskApplyQueryService.query(riskApplyQueryDto);
                    riskSummaryResponseVO.setMobileRelationWechatFingerPrintCount(query.getMobileRelationWechatFingerPrintCount());
                    riskSummaryResponseVO.setMobileRelationAppFingerPrintCount(query.getMobileRelationAppFingerPrintCount());
                    riskSummaryResponseVO.setMobileRelationAppFingerPrints(query.getMobileRelationAppFingerPrints());
                    riskSummaryResponseVO.setMemberIdRelationReceivePhoneCount(query.getMemberIdRelationReceivePhoneCount());
                    riskSummaryResponseVO.setMemberIdRelationReceivePhones(query.getMemberIdRelationReceivePhones());
                    riskSummaryResponseVO.setReceivePhoneRelationOrderCount(query.getReceivePhoneRelationOrderCount());
                    riskSummaryResponseVO.setReceivePhoneRelationMemberIds(query.getReceivePhoneRelationMemberIds());
                    riskSummaryResponseVO.setDeviceFingerprintRelationMobile(query.getDeviceFingerprintRelationMobile());
                    riskSummaryResponseVO.setDeviceFingerprintRelationMobileCount(query.getDeviceFingerprintRelationMobileCount());
                }
            } catch (Exception e) {
                log.error("查询风险图谱失败，失败原因：{}", e.getMessage(), e);
            }
            //获取会员新增详情
            UserScoreResp resp = UserScoreResp.builder().phone(mobile).build();
            resp = userScoreService.getUserScoreResp(yhMember, resp);
            if(resp!=null){
                riskSummaryResponseVO.setMemberId(resp.getMemberId());
                riskSummaryResponseVO.setFingerPrint(resp.getFingerPrint());
                riskSummaryResponseVO.setPrintCode(resp.getPrintCode());
                riskSummaryResponseVO.setShopName(resp.getShopName());
                riskSummaryResponseVO.setRegisterTime(resp.getRegisterTime());
                riskSummaryResponseVO.setIp(resp.getIp());
            }
            //判断是否需要展示手机号查询菜单
            //获取有权限的人员工号列表
            String erpNo = userHelper.getUserInfo().getLoginName();
            List<String> simpleValueFromCache = configurationManageClient.getSimpleValueFromCache(RiskController.JURISDICTION_0003);
            riskSummaryResponseVO.setMobileDetailAdm(Optional.ofNullable(simpleValueFromCache).orElse(Lists.newArrayList()).contains(erpNo));
            return riskSummaryResponseVO;
        }
    }


    /**
     * 獲取風險等級的描述
     *
     * @param mobile
     * @return
     */
    private String getRiskLevelDescription(String mobile, Long memberId) {
        if (StringUtils.isBlank(mobile) || null == memberId) {
            return "";
        }
        SearchRequestVO vo = new SearchRequestVO();
        vo.setMemberId(String.valueOf(memberId));
        vo.setMobile(mobile);
        vo.setReceiver_phone_no(mobile);
        vo.setStrategyNames(Lists.newArrayList(TOUT_MARK));
        List<Map<String, Object>> antiCheatList = antiRiskService.antiCheatMultiAll(vo);
        double toutScore = 0d;
        for (Map<String, Object> map : antiCheatList) {
            if (StringUtils.equals((String) map.get("name"), TOUT_MARK)) {
                toutScore = (Double) map.get("score");
                break;
            }
        }
        String config = ConfigManager.getInstance().getConfig("RISK_CENTER", RISK_ORDER_CATTLE_SCORE_RANGE);
        String range = StringUtils.isNotBlank(config) ? config : ORDER_CATTLE_SCORE_RANGE;
        int level = rangeMapingRisk(toutScore, range);
        log.info("[获取算法结果]从算法部门获取风险等级。mobile={}, level={}", mobile, level);
        AlgorithmRiskLevelEnum levelEnum = AlgorithmRiskLevelEnum.getByValue(level);
        if (levelEnum != null) {
            return levelEnum.getDesc();
        }
        return "";
    }

    /**
     * 判断某个数字是否在某个区间，并根据区间返回相应风险等级
     *
     * @param score 当前数值
     * @return RiskGatewayLevelEnum 风险等级
     */
    private Integer rangeMapingRisk(double score, String rangeStr) {
        String[] range = rangeStr.split(",");
        Double min = Double.parseDouble(range[0]);
        Double max = Double.parseDouble(range[1]);
        return Range.atLeast(max).contains(score) ? 2 : Range.closedOpen(min, max).contains(score) ? 1 : 0;

    }

    @ApiOperation("查询当前会员状态")
    @GetMapping("/summary/verify")
    @MethodAroundLog(remark = "查询当前会员状态")
    @OpenAPI(products = {ProductType.ALLIEDWEB}, authorities = {"*"})
    public long getMemberState(String mobile, Long memberId) {
        if (StringUtils.isBlank(mobile) && memberId == null) {
            throw new BadParameterException("手机号和会员号不能全为空，请检查");
        }
        if (StringUtils.isBlank(mobile)) {
            mobile = memberService.getMemberMobile(memberId);
        }
        String erpNo = userHelper.getUserInfo().getLoginName();
        //获取有权限的人员工号列表
        List<String> simpleValueFromCache = configurationManageClient.getSimpleValueFromCache(JURISDICTION_0002);
        Boolean flag = Optional.ofNullable(simpleValueFromCache).orElse(Lists.newArrayList()).contains(erpNo);
        try {
            Response<YhMember> statelessMemberByMobile = memberService.getStatelessMemberByMobile(mobile);
            if (!statelessMemberByMobile.isSuccess()) {
                throw new BusinessException("获取会员信息失败，code=" + statelessMemberByMobile.getCode() +
                        ",message=" + statelessMemberByMobile.getMessage());
            }
            YhMember data = statelessMemberByMobile.getData();
            if (data == null) {
                log.info("查询当前会员状态，data为空,mobile={}", mobile);
                Boolean result = Optional.ofNullable(riskCoreEngineService.getHighLevelCustomerCurrentStatusInfo(mobile).getResult())
                        .map(t -> t.size() > 0)
                        .orElse(false);
                if (!result) {
                    return flag ? Long.parseLong(mobile) : -1L;
                }
                return Long.parseLong(mobile);
            }
            Integer status = data.getStatus();
            log.info("查询当前会员状态，status={},mobile={}", status, mobile);
            if (MemberState.DELETED.getValue() == status) {
                return flag ? Long.parseLong(mobile) : -1L;
            }
        } catch (Exception e) {
            log.error("查询当前会员状态，执行失败,失败原因:{},mobile={}", e.getMessage(), mobile, e);
            throw new BaseKnownException(BaseKnownStatusEnum.FAIL.getCode(), e.getMessage());
        }
        return Long.parseLong(mobile);
    }


    @ApiOperation("查询风控操作历史")
    @GetMapping(value = "/operation/history")
    @OpenAPI(products = {ProductType.ALLIEDWEB}, authorities = {"yhcrm:risk:black:history"})
    @ResponseBody
    @MethodAroundLog(remark = "查询风控操作历史(##页面没有做任何展示了，需要前端再次确认下##)")
    public List<RiskOperationHistoryVO> getRiskOpsHistory(@RequestParam(value = "mobile", required = false) String mobile) {
        return applyProcessService.getRiskOpsHistory(mobile);
    }

    @ApiOperation("查询支付账号列表")
    @GetMapping(value = "/paylock/info")
    @OpenAPI(products = {ProductType.ALLIEDWEB}, authorities = {"yhcrm:risk:black:pay"})
    @ResponseBody
    @MethodAroundLog(remark = "查询支付账号列表")
    public List<PayLockVO> getPayLockDetail(@RequestParam(value = "mobile", required = false) String mobile) {
        if (DiamondConfigUtils.getSwitchOn(DiamondConfigEnum.RISK_CENTER_APPLY_SWITCH)) {
            List<RiskPayLockResp> payAccountList = riskPayInfoService.listRiskPayByMobile(mobile);
            List<PayLockVO> results = Optional.ofNullable(payAccountList).orElse(new ArrayList<>()).stream()
                    .map(r -> new PayLockVO().buildByRiskPayLockResp(r))
                    .collect(Collectors.toList());
            return results;
        } else {
            Long memberId = Optional.ofNullable(memberService.getMemberByMobile(mobile))
                    .map(YhMember::getId)
                    .orElse(null);
            List<RiskPayLockResp> riskPayLockResps = new ArrayList<>();
            if (null != memberId) {
                log.info("查询锁定信息,memberId[{}]", memberId);
                List<RiskPageEntity> riskPageEntityList = Optional.ofNullable(riskCorePayLocksService.selectPayAccountByMemberId(memberId))
                        .filter(RiskCoreResponse::isOk)
                        .map(RiskCoreResponse::getResult)
                        .orElse(Lists.newArrayList()).stream()
                        .map(p -> {
                            RiskPageEntity dest = new RiskPageEntity();
                            BeanUtils.copyProperties(p, dest);
                            return dest;
                        }).collect(Collectors.toList());
                riskPayLockResps =
                        riskPageEntityList.stream().map(this::buildRiskPayLockResp).filter(Objects::nonNull).collect(Collectors.toList());
            }
            return Optional.of(riskPayLockResps)
                    .orElse(new ArrayList<>()).stream()
                    .map(r -> new PayLockVO().buildByRiskPayLockResp(r))
                    .collect(Collectors.toList());
        }
    }

    private RiskPayLockResp buildRiskPayLockResp(RiskPageEntity riskPageEntity) {
        if (riskPageEntity == null) {
            return null;
        }
        PayModeEnum payModeEnum = Stream.of(PayModeEnum.values()).filter(s -> Objects.equals(s.getValue(), riskPageEntity.getPayMode())).findFirst().orElse(PayModeEnum.UNKNOWN);
        if (payModeEnum.getValue() == 0) {
            log.warn("buildRiskPayLockResp-Exception:{}", JSON.toJSONString(riskPageEntity));
        }
        RiskPayLockResp result = RiskPayLockResp.builder()
                .lockTime(riskPageEntity.getLockAt())
                .payMode(riskPageEntity.getPayMode())
                .payModeName(payModeEnum.getDescription())
                .memberLimit(Optional.ofNullable(riskPageEntity.getMemberLimit()).orElse(0))
                .thirdpartyUserIdentity(riskPageEntity.getThirdpartyUserIdentity())
                .lockStatus(riskPageEntity.getLockStatus()).build();
        return result;
    }

    @ApiOperation("查询支付账号关联的手机号")
    @PostMapping(value = "/paylock/detail")
    @OpenAPI(products = {ProductType.ALLIEDWEB}, authorities = {"yhcrm:risk:black:pay"})
    @ResponseBody
    @MethodAroundLog(remark = "查询支付账号关联的手机号")
    public List<PayLockDetailVO> getPayLockDetail(@RequestBody PayLockDetailQueryVO payLockDetailQueryVO) {
        String identity = payLockDetailQueryVO.getThirdpartyUserIdentity();
        Integer payMode = payLockDetailQueryVO.getPayMode();
        List<PayRelativeDetail> details = new ArrayList<>();
        if (DiamondConfigUtils.getSwitchOn(DiamondConfigEnum.RISK_CENTER_APPLY_SWITCH)) {
            details = riskPayInfoService.listRelativeMobile(identity, payMode);
        } else {
            details = Optional.ofNullable(riskCoreOrderPayIdentityService.listRelativeMobile(identity, payMode))
                    .filter(RiskCoreResponse::isOk)
                    .map(RiskCoreResponse::getResult)
                    .orElseThrow(() -> new BaseKnownException(1, "查询支付账号关联的手机号失败"))
                    .stream()
                    .map(t -> new PayRelativeDetail(t.getMobile(), t.getPayTime(), t.getBindTime(), t.getBindStatus())).collect(Collectors.toList());
        }
        List<PayLockDetailVO> results = details.stream().map(
                d -> new PayLockDetailVO(Optional.ofNullable(d.getMobile()).orElse(StringUtils.EMPTY),
                        DateUtils.format(d.getPayTime()), d.getBindStatus() == 1 ? DateUtils.format(d.getBindTime()) : "",
                        d.getBindStatus())).collect(Collectors.toList());
        return results;

    }
    @ApiOperation("解绑支付账号关联的手机号")
    @PostMapping(value = "/paylock/detail/unBind")
    @OpenAPI(products = {ProductType.ALLIEDWEB}, authorities = {"yhcrm:risk:black:pay"})
    @ResponseBody
    @MethodAroundLog(remark = "解绑支付账号关联的手机号")
    public Boolean unBindRelativeAccount(@RequestBody PayLockDetailQueryVO payLockDetailQueryVO) {
        String identity = payLockDetailQueryVO.getThirdpartyUserIdentity();
        Integer payMode = payLockDetailQueryVO.getPayMode();
        String mobile = payLockDetailQueryVO.getMobile();
        if (DiamondConfigUtils.getSwitchOn(DiamondConfigEnum.RISK_CENTER_APPLY_SWITCH)) {
            return riskPayInfoService.unBindRelativeAccount(identity, payMode, mobile);
        } else {
            return Optional.ofNullable(riskCoreOrderPayIdentityService.unBindRelativeAccount(identity, payMode, mobile))
                    .filter(s -> s.isOk() && s.getResult() == Boolean.TRUE)
                    .map(RiskCoreResponse::getResult)
                    .orElseThrow(() -> new BaseKnownException(1, "解绑支付账号关联的手机号失败"));
        }
    }

/*
	@GetMapping(value = "/black/info/{mobile}")
	@OpenAPI(products= {ProductType.ALLIEDWEB}, authorities= {"yhcrm:*"})
	@ResponseBody
	public RiskBlackInfoResponse getSimpleRiskInfo(@PathVariable("mobile") String mobile) {
		return riskControlService.getSimpleRiskInfoForCustomer(mobile);
	}
	*/

//	@Deprecated
	/*private void checkAuthOfAddBlackList(String user) {
    	String rls = ConfigManager.getInstance().getConfig("RISK_CUSTOM_CONTROL", "blacklist-ops-auth");
    	if(rls != null && !rls.isEmpty()) {
    		String[] rd = rls.split(",");
    		if(rd != null && rd.length > 0) {
    			for(String uid : rd) {
    				if(uid.equals(user)) {
    					return;
    				}
    			}
    		}
    	}
		throw ErrorCodeEnum.ERROR_CODE_PERMISSION.buildBaseKnownException();
    }*/

	/*@RequestMapping(value = "/relativemobile/{mobile}", method = RequestMethod.GET)
	@OpenAPI(products = {ProductType.ALLIEDWEB}, authorities = {"yhcrm:*"})
	@ResponseBody
	public RiskRelativeMobileResponse getMemberRelativeMobileInfoList(@PathVariable("mobile") String mobile) {
		return riskControlService.getMemberRelativeMobileInfoList(mobile);
	}*/

    @ApiOperation("更新关联手机号")
    @PostMapping(value = "/relativeMobile/update")
    @OpenAPI(products = {ProductType.ALLIEDWEB}, authorities = {"yhcrm:risk:black:updatemobile"})
    @ResponseBody
    public void updateMemberRelativeMobileInfoList(@RequestBody MobileOperationVO mobileOperationVO) {
        String mobile = mobileOperationVO.getMobile();
        try {
            if (DiamondConfigUtils.getSwitchOn(DiamondConfigEnum.RISK_CENTER_APPLY_SWITCH)) {
                riskControlService.updateMemberRelativeMobileInfoList(mobile);
            } else {
                riskCoreControlManageService.updateMemberRelativeMobileInfoList(mobile);
            }
        } catch (Exception e) {
            logger.error("黑名单关联手机更新异常 {} ", mobile, e);
            throw e;
        }
    }

    @ApiOperation("加入白名单")
    @PostMapping(value = "/white/add")
    @OpenAPI(products = {ProductType.ALLIEDWEB}, authorities = {"yhcrm:risk:black:addwhite"})
    @ResponseBody
    @MethodAroundLog(remark = "加入白名单")
    public String addWhite(@RequestBody WhiteAddVO whiteAddVO) {
        String mobile = whiteAddVO.getMobile();
        String reason = whiteAddVO.getReason();
        String operator = getCurrentUser();
        riskOperationService.addToWhite(mobile, operator, reason);
        return CommonConstants.RESPONSE_SUCCESS;
    }

    @ApiOperation("解锁支付账号")
    @PostMapping(value = "/pay/unlock")
    @OpenAPI(products = {ProductType.ALLIEDWEB}, authorities = {"yhcrm:risk:black:unlock"})
    @ResponseBody
    @MethodAroundLog(remark = "解锁支付账号")
    public String unlockPayAccount(@RequestBody PayAccountVO payAccountVO) {
        int payMode = payAccountVO.getPayMode();
        String thirdpartyUserIdentity = payAccountVO.getThirdpartyUserIdentity();
        String operator = getCurrentUser();
        if(DiamondConfigUtils.getSwitchOn(DiamondConfigEnum.RISK_CENTER_APPLY_SWITCH)){
            riskOperationService.unlockPayAccount(payMode, thirdpartyUserIdentity, operator);
        } else {
            Optional.ofNullable(riskCorePayLocksService.unlockPayAccount(payMode, thirdpartyUserIdentity, operator))
                    .filter(RiskCoreResponse::isOk)
                    .orElseThrow(() -> new BaseKnownException(1, "解锁支付账号异常"));
        }
        return CommonConstants.RESPONSE_SUCCESS;
    }

    private String getCurrentUser() {
        String user = userHelper.getCurrentUserLoginName();
        if (StringUtils.isBlank(user)) {
            user = "system";
        }
        return user;
    }

    @Deprecated
    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    @OpenAPI(products = {ProductType.ALLIEDWEB}, authorities = {"yhcrm:*"})
    @ResponseBody
    public RiskControlResponse checkAuthOfBlackList() {
        RiskControlResponse res = new RiskControlResponse();
        String user = userHelper.getCurrentUserLoginName();
        if (user == null || user.isEmpty()) {
            res.setIsSuccess(false);
            res.setMessage("没有获取到当前登陆用户名!");
            return res;
        }
//		checkAuthOfAddBlackList(user);
        return res;
    }


    @Deprecated
    @ApiOperation("获取权限用户")
    @RequestMapping(value = "/authMembers", method = RequestMethod.GET)
    @OpenAPI(products = {ProductType.ALLIEDWEB}, authorities = {"yhcrm:*"})
    @ResponseBody
    public RiskControlResponse getAuthMembers() {
        RiskControlResponse res = new RiskControlResponse();
        String rls = ConfigManager.getInstance().getConfig("RISK_CUSTOM_CONTROL", "blacklist-ops-auth");
        if (rls != null && !rls.isEmpty()) {
            res.setMessage(rls);
        } else {
            res.setIsSuccess(false);
            res.setMessage("没有设置相关权限人员!");
        }
        return res;
    }


    private List<String> parseExcelFile(MultipartFile file) {
        List<String> mobiles = new ArrayList<>();
        try (Workbook workbook = ExcelUtils.buildWorkbook(file)) {
            Sheet sheet = workbook.getSheetAt(0);
            int i = 1;
            int rowNum = 0;
            int emptyCount = 0;
            Row r;
            String mobile;
            //连续空行超过10跳过
            while ((r = sheet.getRow(i)) != null && emptyCount <= 10) {
                rowNum++;
                if (null == r.getCell(0)) {
                    emptyCount++;
                    i++;
                    continue;
                }
                mobile = ExcelUtils.getCellValue(r.getCell(0));
                if (org.apache.commons.lang.StringUtils.isBlank(mobile) ) {
                    i++;
                    emptyCount++;
                    continue;
                }
                emptyCount = 0;
                mobiles.add(mobile);
                i++;
            }
        } catch (Exception e) {
            log.error("excel文件解析异常,文件名[{}]", file.getName(), e);
            ExceptionLogger.log("excel文件解析异常,文件名[" + file.getName() + "]", e);
            throw new BaseKnownException(400003, "excel文件解析异常");
        }
        return mobiles;
    }


    @ApiOperation("离线更新数据")
    @RequestMapping(value = "/offlineUpdateCache", method = RequestMethod.POST)
    @ResponseBody
    public void offlineUpdatePhoneCache(@RequestParam(value = "request") String request, @RequestParam(value = "token") String token) {
        log.info("offlineUpdateUserCache-request:{}", request);
        if (StringUtils.isEmpty(request)|| !RiskHubConstants.OFFLINE_UPDATE_PHONE_CACHE_TOKEN.equals(token)) {
            return;
        }
        try {
            String[] split = request.split(",");
            riskControlService.offlineUpdateUserCache(Arrays.asList(split));
        } catch (Exception e) {
            logger.error("offlineUpdateUserCache-Exception:{} ", request, e);
            throw e;
        }
    }

    @RequestMapping(value = "/getSimilarPic", method = RequestMethod.POST)
    @ResponseBody
    public YhResponse<Map<String, GetSimilarPicResponseVO>> getSimilarPic(@RequestBody GetSimilarPicRequestDto request) {
        log.info("getSimilarPic-request:{}", request);
        try {
            final YhResponse<Map<String, GetSimilarPicResponseVO>> similarPic = picService.getSimilarPic(request);
            return similarPic;
        } catch (Exception e) {
            logger.error("getSimilarPic-Exception:{} ", request, e);
            throw e;
        }
    }

    @GetMapping("/summary/get/member/id")
    @MethodAroundLog(remark = "查询当前会员id")
    @OpenAPI(products = {ProductType.ALLIEDWEB}, authorities = {"*"})
    public Long getMemberId(String mobile) {
        try {
            if (StringUtils.isBlank(mobile)) {
                throw new BadParameterException("手机号为空，请检查");
            }
            Response<YhMember> statelessMemberByMobile = memberService.getStatelessMemberByMobile(mobile);
            if (!statelessMemberByMobile.isSuccess()) {
                log.warn("获取会员信息失败，code={},message={}", statelessMemberByMobile.getCode(), statelessMemberByMobile.getMessage());
                return null;
            }
            YhMember data = statelessMemberByMobile.getData();
            if (data == null) {
                log.warn("查询当前会员id，data为空,mobile={}", mobile);
                return null;
            }
            return data.getId();
        } catch (Exception e) {
            log.warn("查询当前会员id失败，失败原因：{}", e.getMessage(), e);
            return null;
        }
    }

}
