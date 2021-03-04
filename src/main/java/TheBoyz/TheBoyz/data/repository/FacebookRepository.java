//package TheBoyz.TheBoyz.data.repository;
//
//import TheBoyz.TheBoyz.data.model.FacebookUser;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//public interface FacebookRepository extends JpaRepository<FacebookUser,Long>{
//    public Page<FacebookUser> findByFacebookIDOrderByFacebookID(Long ID, Pageable pageable);
//    public Page<FacebookUser> findFacebookUserByFacebookName(String name, Pageable pageable);
//}
