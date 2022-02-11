package it.unikey.testhub_server.BLL.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SessionCountStatisticsDTO {

   private Long activeSession;
   private Long completedSession;
   private Long sentSession;
}
