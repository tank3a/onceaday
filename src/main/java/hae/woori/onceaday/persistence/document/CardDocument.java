package hae.woori.onceaday.persistence.document;

import hae.woori.onceaday.persistence.vo.EmojiRecord;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@Document(collection = "cards")
public class CardDocument {

	@Id
	private String id;
	@NotNull
	@Field(value = "user_id")
	private String userId;
	@NotNull
	@Field(value = "content")
	private String content;
	@Field(value = "create_time")
	@CreatedDate
	@Indexed
	private LocalDateTime createTime;
	@Field(value = "emotions")
	@Builder.Default
	private List<EmojiRecord> emojiRecords = new ArrayList<>();
	@NotNull
	@Field(value = "bg_color")
	private String bgColor;
}
