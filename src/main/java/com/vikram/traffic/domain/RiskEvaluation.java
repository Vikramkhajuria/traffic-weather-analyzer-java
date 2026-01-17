package com.vikram.traffic.domain;

import java.util.List;

public record RiskEvaluation(RiskLevel level, int score, List<String> reasons) {}
