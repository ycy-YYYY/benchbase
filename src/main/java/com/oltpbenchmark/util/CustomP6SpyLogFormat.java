package com.oltpbenchmark.util;

import com.p6spy.engine.common.P6Util;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;


public class CustomP6SpyLogFormat implements MessageFormattingStrategy {

  @Override
  public String formatMessage(
      int connectionId,
      String now,
      long elapsed,
      String category,
      String prepared,
      String sql,
      String url) {
    return String.format(
        "[timestamp=%s][category=%s][connId=%d][sql=%s]",
        now, category, connectionId, P6Util.singleLine(sql));
  }
}
