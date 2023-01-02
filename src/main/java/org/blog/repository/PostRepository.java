package org.blog.repository;


import java.util.List;
import java.util.Optional;

import javax.persistence.JoinColumn;

import org.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
                                             //it is used to manage the database
//JPARepository
//CRUDRepository
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

	
	@JoinColumn(name="userId")
    @Query(value = "SELECT * FROM POST p WHERE p.category_id = ?1",nativeQuery = true  )
    public List<Post> findByCategoryId(long categoryId);

    @Query(value = "SELECT * FROM POST p WHERE p.user_id = ?1",nativeQuery = true  )
    public List<Post> findPostsByUserId(long userId);
    
    @Query(value = "SELECT * FROM POST p WHERE p.post_title = ?1",nativeQuery = true  )
    public Optional<Post> findPostBypostTitle(String title);
}

