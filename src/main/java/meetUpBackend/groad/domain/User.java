package meetUpBackend.groad.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;

	@Column(name = "userId")
	private String userId;

//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "myPageId")
//	private List<ActSemester> myPageId = new ArrayList<>();

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mypageId")
	private MyPage mypageId;

}
