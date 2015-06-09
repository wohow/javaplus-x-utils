# MySQL-Front 5.1  (Build 2.7)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;


# Host: 127.0.0.1    Database: game
# ------------------------------------------------------
# Server version 5.5.32

#
# Source for table award_info
#

CREATE TABLE `award_info` (
  `uname` int(11) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `VIP` varchar(100) DEFAULT '' COMMENT 'VIP信息-当前充值金额',
  `LAG` varchar(100) DEFAULT '' COMMENT '每日登陆 奖励水晶',
  `LAM` varchar(100) DEFAULT '' COMMENT '每日登陆 奖励金币',
  `LAS` varchar(100) DEFAULT '' COMMENT '每日登陆 奖励体力',
  `LAT` varchar(100) DEFAULT '' COMMENT '每日转发腾讯或者新浪微博',
  `CI` varchar(100) DEFAULT '' COMMENT '连续登录奖励',
  `TU` varchar(100) DEFAULT '' COMMENT '充值奖励',
  `UG` varchar(100) DEFAULT '' COMMENT '升级奖励',
  `AFC` varchar(100) DEFAULT '' COMMENT '普通副本通关奖励',
  `AFE` varchar(100) DEFAULT '' COMMENT '精英副本通关奖励',
  `IM30` varchar(100) DEFAULT '' COMMENT '好友邀请到达30级 奖励',
  `IM40` varchar(100) DEFAULT '' COMMENT '好友邀请到达40级 奖励',
  `IM50` varchar(100) DEFAULT '' COMMENT '好友邀请到达50级 奖励',
  `IM60` varchar(100) DEFAULT '' COMMENT '好友邀请到达60级 奖励',
  `IM70` varchar(100) DEFAULT '' COMMENT '好友邀请到达70级 奖励',
  `IM80` varchar(100) DEFAULT '' COMMENT '好友邀请到达80级 奖励',
  `IM100` varchar(100) DEFAULT '' COMMENT '好友邀请到达100级 奖励',
  `LAMC` varchar(100) DEFAULT '' COMMENT '每日领取月卡',
  `LAMC1` varchar(100) DEFAULT '',
  `LAMC2` varchar(100) DEFAULT '',
  `STC` varchar(100) DEFAULT '' COMMENT '水晶抽卡一次',
  `YTC` varchar(100) DEFAULT '' COMMENT '友情抽卡一次',
  `POP` varchar(100) DEFAULT '' COMMENT '购买体力',
  `CCE1` varchar(100) DEFAULT '' COMMENT '完成10次普通副本',
  `CCE2` varchar(100) DEFAULT '' COMMENT '完成20次普通副本',
  `CCE3` varchar(100) DEFAULT '' COMMENT '完成40次普通副本',
  `CCE4` varchar(100) DEFAULT '' COMMENT '完成80次普通副本',
  `CEE1` varchar(100) DEFAULT '' COMMENT '完成10次精英副本',
  `CEE2` varchar(100) DEFAULT '' COMMENT '完成20次精英副本',
  `CEE3` varchar(100) DEFAULT '' COMMENT '完成40次精英副本',
  `CEE4` varchar(100) DEFAULT '' COMMENT '完成80次精英副本',
  `BDA` varchar(100) DEFAULT '' COMMENT '绑定账号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='系统奖励信息';

#
# Source for table battle_info_base
#

CREATE TABLE `battle_info_base` (
  `u_id` int(11) NOT NULL DEFAULT '0' COMMENT '战报唯一ID',
  `uname` int(11) NOT NULL DEFAULT '0' COMMENT '玩家账户ID',
  `ectype_id` int(11) NOT NULL DEFAULT '0' COMMENT '副本ID',
  `points_id` int(11) NOT NULL DEFAULT '0' COMMENT '关卡ID',
  `the_lv` smallint(6) NOT NULL DEFAULT '0' COMMENT '波数',
  `data` blob NOT NULL COMMENT '数据',
  `timer` int(11) NOT NULL DEFAULT '0' COMMENT '存储时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='玩家战报信息';

#
# Source for table captain_skill_info
#

CREATE TABLE `captain_skill_info` (
  `name` int(11) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `skill_id` int(11) DEFAULT '0' COMMENT '队长技能ID',
  `use_time` tinyint(3) DEFAULT '0' COMMENT '使用重置次数',
  `record_time` int(11) DEFAULT '0' COMMENT '记录时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='重置队长技能信息';

#
# Source for table consumelog
#

CREATE TABLE `consumelog` (
  `date` varchar(15) NOT NULL DEFAULT '',
  `bytes` blob NOT NULL,
  PRIMARY KEY (`date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Source for table consumelog_1
#

CREATE TABLE `consumelog_1` (
  `玩家昵称` varchar(10) NOT NULL DEFAULT '',
  `单抽` int(11) DEFAULT '0',
  `10连抽` int(11) DEFAULT '0',
  `购买体力` int(11) DEFAULT '0',
  `购买金币` int(11) DEFAULT '0',
  `购买PVP` int(11) DEFAULT '0',
  `购买RANK` int(11) DEFAULT '0',
  `刷新队长技能` int(11) DEFAULT '0',
  `购买英雄背包上限` int(11) DEFAULT '0',
  `购买装备背包上限` int(11) DEFAULT '0',
  `购买好友上限` int(11) DEFAULT '0',
  `充值获得` int(11) DEFAULT '0',
  `大龙排行榜` int(11) DEFAULT '0',
  `RANK排行榜` int(11) DEFAULT '0',
  `等级奖励` int(11) DEFAULT '0',
  `副本通关` int(11) DEFAULT '0',
  `系统发放` int(11) DEFAULT '0',
  PRIMARY KEY (`玩家昵称`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Source for table consumelog_30
#

CREATE TABLE `consumelog_30` (
  `玩家昵称` varchar(10) NOT NULL DEFAULT '',
  `单抽` int(11) DEFAULT '0',
  `10连抽` int(11) DEFAULT '0',
  `购买体力` int(11) DEFAULT '0',
  `购买金币` int(11) DEFAULT '0',
  `购买PVP` int(11) DEFAULT '0',
  `购买RANK` int(11) DEFAULT '0',
  `刷新队长技能` int(11) DEFAULT '0',
  `购买英雄背包上限` int(11) DEFAULT '0',
  `购买装备背包上限` int(11) DEFAULT '0',
  `购买好友上限` int(11) DEFAULT '0',
  `充值获得` int(11) DEFAULT '0',
  `大龙排行榜` int(11) DEFAULT '0',
  `RANK排行榜` int(11) DEFAULT '0',
  `等级奖励` int(11) DEFAULT '0',
  `副本通关` int(11) DEFAULT '0',
  `系统发放` int(11) DEFAULT '0',
  PRIMARY KEY (`玩家昵称`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Source for table consumelog_7
#

CREATE TABLE `consumelog_7` (
  `玩家昵称` varchar(10) NOT NULL DEFAULT '',
  `单抽` int(11) DEFAULT '0',
  `10连抽` int(11) DEFAULT '0',
  `购买体力` int(11) DEFAULT '0',
  `购买金币` int(11) DEFAULT '0',
  `购买PVP` int(11) DEFAULT '0',
  `购买RANK` int(11) DEFAULT '0',
  `刷新队长技能` int(11) DEFAULT '0',
  `购买英雄背包上限` int(11) DEFAULT '0',
  `购买装备背包上限` int(11) DEFAULT '0',
  `购买好友上限` int(11) DEFAULT '0',
  `充值获得` int(11) DEFAULT '0',
  `大龙排行榜` int(11) DEFAULT '0',
  `RANK排行榜` int(11) DEFAULT '0',
  `等级奖励` int(11) DEFAULT '0',
  `副本通关` int(11) DEFAULT '0',
  `系统发放` int(11) DEFAULT '0',
  PRIMARY KEY (`玩家昵称`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Source for table dragon_info
#

CREATE TABLE `dragon_info` (
  `is_open` bit(1) NOT NULL DEFAULT b'0' COMMENT '大龙是否开启',
  `hp_base` int(11) DEFAULT '0' COMMENT '大龙初始血量',
  `hp_cur` int(11) DEFAULT '0' COMMENT '大龙当前血量',
  `attack_base` int(11) DEFAULT '0' COMMENT '大龙初始攻击',
  `user_list` varchar(1024) DEFAULT '' COMMENT '参与玩家列表'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='大龙信息';

#
# Source for table ectype_start
#

CREATE TABLE `ectype_start` (
  `name` int(11) NOT NULL DEFAULT '0' COMMENT '玩家唯一ID',
  `content` varchar(10000) DEFAULT '' COMMENT '玩家副本星级内容'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='副本星级';

#
# Source for table ecytpe_base
#

CREATE TABLE `ecytpe_base` (
  `uname` int(11) NOT NULL DEFAULT '0' COMMENT '玩家账户ID',
  `common` varchar(50) DEFAULT '' COMMENT '普通副本',
  `elite` varchar(50) DEFAULT '' COMMENT '精英副本',
  `challenge` varchar(50) DEFAULT '' COMMENT '挑战副本',
  `activity` varchar(50) DEFAULT '' COMMENT '活动副本'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='玩家副本通关记录';

#
# Source for table elite_ecytpe_info
#

CREATE TABLE `elite_ecytpe_info` (
  `uname` int(11) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `time` int(11) DEFAULT '0' COMMENT '记录时间',
  `content` varchar(4096) NOT NULL DEFAULT '' COMMENT '内容（副本ID:关卡ID,每日免费次数,可购买数,记录时间;|）',
  `dragonet_1` varchar(125) DEFAULT '' COMMENT '记录小龙数据(经验)',
  `dragonet_2` varchar(125) DEFAULT '' COMMENT '记录小龙数据(金币)',
  `torefinewithfire` varchar(255) DEFAULT '' COMMENT '试炼'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='英雄副本记录次数信息';

#
# Source for table equip_info
#

CREATE TABLE `equip_info` (
  `u_id` int(11) NOT NULL DEFAULT '0' COMMENT '装备唯一ID',
  `uname` int(11) NOT NULL DEFAULT '0' COMMENT '玩家唯一ID',
  `n_id` int(11) NOT NULL DEFAULT '0' COMMENT '装备表格ID',
  `their_id` int(11) DEFAULT '-1' COMMENT '对应英雄ID',
  `is_remove` bit(1) DEFAULT b'0' COMMENT '是否删除',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `remove_time` int(11) DEFAULT '0' COMMENT '删除时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='装备信息';

#
# Source for table esynthesis_info
#

CREATE TABLE `esynthesis_info` (
  `uname` int(11) NOT NULL DEFAULT '0' COMMENT '用户名',
  `syn_id` varchar(50) DEFAULT '' COMMENT '合成装备信息',
  `stuff_id` varchar(80) DEFAULT '' COMMENT '材料信息',
  `time` int(11) DEFAULT '0' COMMENT '记录时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='装备合成信息';

#
# Source for table fight_reconnect
#

CREATE TABLE `fight_reconnect` (
  `uname` int(11) NOT NULL DEFAULT '0' COMMENT '玩家账户ID',
  `fight_id` int(11) NOT NULL DEFAULT '0' COMMENT '战报ID',
  `points_id` int(11) NOT NULL DEFAULT '0' COMMENT '关卡ID',
  `the_lv` smallint(6) NOT NULL DEFAULT '0' COMMENT '波数',
  `fire_boss_id` int(11) NOT NULL DEFAULT '0' COMMENT '试炼BOSS ID',
  `award_content` varchar(255) NOT NULL COMMENT '准备奖励信息',
  `is_win` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否胜利',
  `is_remove` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否被删'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='玩家记录副本情况';

#
# Source for table friend_info
#

CREATE TABLE `friend_info` (
  `uname` int(11) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `friend_content` varchar(2048) DEFAULT NULL COMMENT '好友信息(好友ID,可赠送值,可领取值)',
  `beg_content` varchar(255) DEFAULT '' COMMENT '申请列表',
  `gv_times` int(11) DEFAULT '0' COMMENT '赠送次数',
  `get_times` int(11) DEFAULT '0' COMMENT '领取次数',
  `record_time` int(11) NOT NULL DEFAULT '0' COMMENT '记录时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='好友数据';

#
# Source for table game_data
#

CREATE TABLE `game_data` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `front_animation` blob COMMENT '开场动画',
  `front_animation1` blob,
  `mikka_login` varchar(255) DEFAULT '' COMMENT '开服时间',
  `ranking` varchar(10240) DEFAULT '' COMMENT '排位排名',
  `activit_data` varchar(100) DEFAULT '' COMMENT '活动开关记录',
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='游戏数据';

#
# Source for table inviting_friend_info
#

CREATE TABLE `inviting_friend_info` (
  `uname` int(11) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `inviting_my` int(11) DEFAULT '0' COMMENT '邀请我的好友ID',
  `my_inviting_content` varchar(1024) DEFAULT '' COMMENT '我邀请的好友信息（好友ID，可以领取的水晶）'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='邀请好友';

#
# Source for table log_purcharse
#

CREATE TABLE `log_purcharse` (
  `transaction_id` varchar(50) NOT NULL DEFAULT '' COMMENT '交易ID',
  `uname` int(11) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `product_id` varchar(125) NOT NULL DEFAULT '' COMMENT '商品ID',
  `money` float(11,2) DEFAULT '0.00' COMMENT '充值钱数',
  `quantity` int(11) DEFAULT '0' COMMENT '数量',
  `purchase_date` varchar(50) NOT NULL DEFAULT '' COMMENT '交易时间',
  `receipt` varchar(1024) NOT NULL DEFAULT '' COMMENT '收据'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='玩家充值信息';

#
# Source for table ltv
#

CREATE TABLE `ltv` (
  `日期` varchar(15) NOT NULL DEFAULT '',
  `新近设备` int(11) NOT NULL DEFAULT '0',
  `1日` float(11,2) DEFAULT NULL,
  `2日` float(11,2) DEFAULT NULL,
  `3日` float(11,2) DEFAULT NULL,
  `4日` float(11,2) DEFAULT NULL,
  `5日` float(11,2) DEFAULT NULL,
  `6日` float(11,2) DEFAULT NULL,
  `7日` float(11,2) DEFAULT NULL,
  `8日` float(11,2) DEFAULT NULL,
  `9日` float(11,2) DEFAULT NULL,
  `10日` float(11,2) DEFAULT NULL,
  `11日` float(11,2) DEFAULT NULL,
  `12日` float(11,2) DEFAULT NULL,
  `13日` float(11,2) DEFAULT NULL,
  `14日` float(11,2) DEFAULT NULL,
  `15日` float(11,2) DEFAULT NULL,
  `16日` float(11,2) DEFAULT NULL,
  `17日` float(11,2) DEFAULT NULL,
  `18日` float(11,2) DEFAULT NULL,
  `19日` float(11,2) DEFAULT NULL,
  `20日` float(11,2) DEFAULT NULL,
  `21日` float(11,2) DEFAULT NULL,
  `22日` float(11,2) DEFAULT NULL,
  `23日` float(11,2) DEFAULT NULL,
  `24日` float(11,2) DEFAULT NULL,
  `25日` float(11,2) DEFAULT NULL,
  `26日` float(11,2) DEFAULT NULL,
  `27日` float(11,2) DEFAULT NULL,
  `28日` float(11,2) DEFAULT NULL,
  `29日` float(11,2) DEFAULT NULL,
  `30日` float(11,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

#
# Source for table mail_info
#

CREATE TABLE `mail_info` (
  `mailId` int(11) NOT NULL DEFAULT '0' COMMENT '邮件唯一ID',
  `uname` int(11) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `type` smallint(6) NOT NULL DEFAULT '0' COMMENT '邮件类型',
  `title` varchar(50) DEFAULT '' COMMENT '邮件标题',
  `content` varchar(1024) DEFAULT '' COMMENT '邮件内容',
  `is_read` bit(1) DEFAULT b'0' COMMENT '是否读取（1已经读取 0还没有读取）',
  `surplus_time` int(11) DEFAULT '0' COMMENT '剩余时间',
  `item` varchar(125) DEFAULT '' COMMENT '物品'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='玩家邮件信息';

#
# Source for table pvp_mate_battle_info
#

CREATE TABLE `pvp_mate_battle_info` (
  `uId` int(11) NOT NULL DEFAULT '0' COMMENT '战报ID',
  `uname` int(11) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `to_uname` int(11) NOT NULL DEFAULT '0' COMMENT '打败你的用户ID',
  `to_hero_1` varchar(255) DEFAULT '' COMMENT '挑战者 英雄信息',
  `to_hero_2` varchar(255) DEFAULT '',
  `to_hero_3` varchar(255) DEFAULT '',
  `to_hero_4` varchar(255) DEFAULT '',
  `to_hero_5` varchar(255) DEFAULT '',
  `mi_hero_1` varchar(255) DEFAULT '' COMMENT '自己的 英雄信息',
  `mi_hero_2` varchar(255) DEFAULT '',
  `mi_hero_3` varchar(255) DEFAULT '',
  `mi_hero_4` varchar(255) DEFAULT '',
  `mi_hero_5` varchar(255) DEFAULT '',
  `data` blob NOT NULL COMMENT '战报信息',
  `loot_cash` int(11) DEFAULT '0' COMMENT '抢夺金币',
  `is_win` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否胜利',
  `revenge` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否复仇',
  `is_revenge` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否使用复仇之心',
  `time` int(11) DEFAULT '0' COMMENT '记录时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='pvp匹配战报信息';

#
# Source for table pvp_mate_info
#

CREATE TABLE `pvp_mate_info` (
  `uname` int(11) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `dan_grad` smallint(6) NOT NULL DEFAULT '0' COMMENT '段位',
  `grade` int(11) NOT NULL DEFAULT '0' COMMENT '分数',
  `standings` int(11) NOT NULL DEFAULT '0' COMMENT '战绩',
  `max_victory` int(11) NOT NULL DEFAULT '0' COMMENT '最大连杀',
  `record_victory` int(11) NOT NULL DEFAULT '0' COMMENT '记录连杀',
  `max_failure` int(11) NOT NULL DEFAULT '0' COMMENT '最大连跪',
  `record_failure` int(11) NOT NULL DEFAULT '0' COMMENT '记录连跪',
  `today_count` smallint(6) NOT NULL DEFAULT '0' COMMENT '每日可匹配次数',
  `buy_count` smallint(6) NOT NULL DEFAULT '0' COMMENT '每日已可购买匹配次数',
  `mate_count` int(11) DEFAULT '0' COMMENT '一共 匹配次数',
  `award` varchar(255) DEFAULT '' COMMENT '每日领取奖励信息',
  `is_getwelfare` bit(1) DEFAULT b'0' COMMENT '是否领取了每日福利',
  `by_loot_count` smallint(6) DEFAULT '5' COMMENT '可被抢夺次数',
  `record_time` int(11) NOT NULL DEFAULT '0' COMMENT '记录时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='pvp匹配信息';

#
# Source for table qualifying_battle_info
#

CREATE TABLE `qualifying_battle_info` (
  `u_id` int(11) NOT NULL DEFAULT '0' COMMENT '唯一ID',
  `uname` int(11) DEFAULT '0' COMMENT '玩家唯一ID',
  `type` tinyint(3) DEFAULT '0' COMMENT '战斗类型',
  `data` blob COMMENT '数据',
  `quilt_uid` int(11) DEFAULT '0' COMMENT '对方玩家ID',
  `rank` int(11) DEFAULT '0' COMMENT '起伏排名',
  `timer` int(11) DEFAULT '0' COMMENT '添加时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='排位战报';

#
# Source for table qualifying_info
#

CREATE TABLE `qualifying_info` (
  `uId` int(11) NOT NULL DEFAULT '0' COMMENT '玩家唯一ID',
  `standings` int(11) DEFAULT '0' COMMENT '战绩',
  `residue_degree` tinyint(3) DEFAULT '0' COMMENT '剩余次数',
  `frequency` tinyint(3) DEFAULT '0' COMMENT '可购买次数'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='排位赛';

#
# Source for table talent_info
#

CREATE TABLE `talent_info` (
  `uname` int(11) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `phy_attack` varchar(50) DEFAULT '' COMMENT '物理攻击',
  `magic_attack` varchar(50) DEFAULT '' COMMENT '法术攻击',
  `hp` varchar(50) DEFAULT '' COMMENT '生命',
  `phy_penetration` varchar(50) DEFAULT '' COMMENT '物理穿透',
  `magic_penetration` varchar(50) DEFAULT '' COMMENT '法术穿透',
  `phy_resist` varchar(50) DEFAULT '' COMMENT '物理抗性',
  `magic_resist` varchar(50) DEFAULT '' COMMENT '法术抗性',
  `dodge` varchar(50) DEFAULT '' COMMENT '闪避',
  `hit` varchar(50) DEFAULT '' COMMENT '命中',
  `crit` varchar(50) DEFAULT '' COMMENT '暴击',
  `toughness` varchar(50) DEFAULT '' COMMENT '韧性'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='玩家天赋信息';

#
# Source for table team_base
#

CREATE TABLE `team_base` (
  `uname` int(11) NOT NULL DEFAULT '0' COMMENT '玩家ID',
  `content` varchar(255) DEFAULT NULL COMMENT '记录内容（英雄唯一ID，位置，是否死亡, 是否绝对死亡）',
  `assist_friends` varchar(255) DEFAULT '' COMMENT '协助好友信息',
  `mate_content_green` varchar(255) DEFAULT '' COMMENT '匹配绿卡阵型',
  `mate_content_blue` varchar(255) DEFAULT '' COMMENT '匹配蓝卡阵型',
  `mate_content_purple` varchar(255) DEFAULT '' COMMENT '匹配紫卡阵型',
  `qualifying_content` varchar(255) DEFAULT '' COMMENT '排位赛阵型',
  `mate_last_type` smallint(6) DEFAULT '1' COMMENT '匹配最后一次主动操作的颜色卡片'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='玩家的团队信息';

#
# Source for table tickling_info
#

CREATE TABLE `tickling_info` (
  `Id` int(11) NOT NULL DEFAULT '0',
  `uname` int(11) DEFAULT '0' COMMENT '角色唯一ID',
  `content` varchar(10240) DEFAULT '' COMMENT '内容',
  `time` int(11) DEFAULT '0' COMMENT '时间',
  `reply` varchar(10240) DEFAULT '' COMMENT '回复信息'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='反馈信息';

#
# Source for table user_base
#

CREATE TABLE `user_base` (
  `name` int(11) NOT NULL DEFAULT '0' COMMENT '玩家账户ID',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建的时间',
  `nick_name` varchar(30) NOT NULL DEFAULT '' COMMENT '昵称',
  `level` smallint(3) NOT NULL DEFAULT '1' COMMENT '玩家等级',
  `vip_level` smallint(3) DEFAULT '0' COMMENT 'VIP等级',
  `recharge_gold` int(11) DEFAULT '0' COMMENT '通过充值的水晶',
  `rmb` int(11) DEFAULT '0',
  `recharge_money` float(11,2) DEFAULT '0.00' COMMENT '充值人民币',
  `recharge_money1` float(11,2) DEFAULT '0.00',
  `recharge_money2` float(11,2) DEFAULT '0.00',
  `strongestares_recharge` float(11,2) DEFAULT '0.00',
  `exp` int(11) DEFAULT '0' COMMENT '玩家当前经验',
  `cash` int(11) DEFAULT '0' COMMENT '金币',
  `gold` int(11) DEFAULT '0' COMMENT '水晶',
  `trophy_num` int(11) DEFAULT '0' COMMENT '奖杯个数',
  `month_card_fate` mediumint(9) DEFAULT '0' COMMENT '月卡天数',
  `month_card_fate_1` mediumint(9) DEFAULT '0',
  `month_card_fate_2` mediumint(9) DEFAULT '-1',
  `restriction` varchar(50) DEFAULT '' COMMENT '限购ID',
  `friend_value` int(11) DEFAULT '0' COMMENT '友情点',
  `cur_strength` smallint(6) NOT NULL DEFAULT '100' COMMENT '玩家当前体力值',
  `max_strength` smallint(6) NOT NULL DEFAULT '100' COMMENT '体力值上限',
  `strength_record_time` int(11) NOT NULL DEFAULT '0' COMMENT '体力值回复记录时间',
  `buy_str_count` smallint(6) NOT NULL DEFAULT '0' COMMENT '可购买体力次数',
  `buy_str_count_max` smallint(6) DEFAULT '1' COMMENT '最大可购买次数',
  `add_buystr_count` smallint(6) DEFAULT '0',
  `pvp_matebuy_count` smallint(3) DEFAULT '0' COMMENT '购买PVP次数上限',
  `bag_capacity` mediumint(9) NOT NULL DEFAULT '100' COMMENT '背包容量',
  `equip_capacity` mediumint(9) DEFAULT '100' COMMENT '装备背包上限',
  `friend_capacity` mediumint(9) DEFAULT '10' COMMENT '好友上限',
  `status` tinyint(3) NOT NULL DEFAULT '3' COMMENT '玩家状态，GUEST(1),NEW(2),LOGIN(3),BAN(4)',
  `login_count` int(11) NOT NULL DEFAULT '0' COMMENT '玩家总的登陆次数',
  `continuous_login_count` int(11) DEFAULT '0' COMMENT '连续登陆次数',
  `lastLogin_time` int(11) DEFAULT '0' COMMENT '上次登录时间',
  `lastlogout_time` int(11) NOT NULL DEFAULT '0' COMMENT '上次下线时间',
  `is_adult` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否成年',
  `newbie_guide` int(11) DEFAULT '0' COMMENT '新手引导ID',
  `xinkai` float(11,2) DEFAULT '0.00' COMMENT '新开服是否领取奖励',
  `xinkai1` float(11,2) DEFAULT '0.00',
  `xinkai2` float(11,2) DEFAULT '0.00',
  `is_turnover` bit(1) DEFAULT b'0' COMMENT '是否流逝',
  `is_firsttimethatcard` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否第一次抽卡',
  `is_cardto10` tinyint(3) DEFAULT '0',
  `is_hthemeweek` tinyint(3) DEFAULT '0',
  `all_buytimes` varchar(50) DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='玩家基础 属性表';

#
# Source for table user_hero_base
#

CREATE TABLE `user_hero_base` (
  `u_id` int(11) NOT NULL DEFAULT '0' COMMENT '玩家英雄唯一ID',
  `uname` int(11) NOT NULL DEFAULT '0' COMMENT '玩家账户ID',
  `hero_nid` int(11) NOT NULL DEFAULT '0' COMMENT '表格ID',
  `hero_lv` smallint(6) NOT NULL DEFAULT '0' COMMENT '英雄等级',
  `hero_exp` int(11) DEFAULT '0' COMMENT '英雄经验',
  `quality` varchar(10) DEFAULT 'GREEN,0' COMMENT '英雄品质',
  `accord_skill_lv` tinyint(3) DEFAULT '1' COMMENT '主动技能等级',
  `captain_skill` int(11) DEFAULT '0' COMMENT '队长技能ID',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `is_remove` bit(1) DEFAULT b'0' COMMENT '是否被删',
  `remove_time` int(11) DEFAULT '0' COMMENT '删除时间',
  `equip_content` varchar(100) DEFAULT '' COMMENT '装备信息'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='玩家英雄基础 属性表';

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
