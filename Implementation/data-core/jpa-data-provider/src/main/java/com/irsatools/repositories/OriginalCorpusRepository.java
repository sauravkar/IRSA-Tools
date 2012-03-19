/**
 *  File:   OriginalCorpusRepository
 *  Author: Nikolay Semenov <ns.semenov@gmail.com>
 *  Date:   17.03.12
 */
package com.irsatools.repositories;

import com.irsatools.entities.global.OriginalCorpus;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA-Data-Spring repository to manage {@link com.irsatools.entities.global.OriginalCorpus} entities
 */
public interface OriginalCorpusRepository extends JpaRepository<OriginalCorpus, String> {
}
