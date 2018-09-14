package io.blocko.ethboard.service;

import io.blocko.ethboard.domain.Wallet;
import io.blocko.ethboard.repository.WalletRepository;
import io.blocko.ethboard.service.dto.WalletDTO;
import io.blocko.ethboard.service.mapper.WalletMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing Wallet.
 */
@Service
@Transactional
public class WalletService {

    private final Logger log = LoggerFactory.getLogger(WalletService.class);

    private final WalletRepository walletRepository;

    private final WalletMapper walletMapper;

    public WalletService(WalletRepository walletRepository, WalletMapper walletMapper) {
        this.walletRepository = walletRepository;
        this.walletMapper = walletMapper;
    }

    /**
     * Save a wallet.
     *
     * @param walletDTO the entity to save
     * @return the persisted entity
     */
    public WalletDTO save(WalletDTO walletDTO) {
        log.debug("Request to save Wallet : {}", walletDTO);
        Wallet wallet = walletMapper.toEntity(walletDTO);
        wallet = walletRepository.save(wallet);
        return walletMapper.toDto(wallet);
    }

    /**
     * Get all the wallets.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<WalletDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Wallets");
        return walletRepository.findAll(pageable)
            .map(walletMapper::toDto);
    }


    /**
     * Get one wallet by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<WalletDTO> findOne(Long id) {
        log.debug("Request to get Wallet : {}", id);
        return walletRepository.findById(id)
            .map(walletMapper::toDto);
    }

    /**
     * Delete the wallet by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Wallet : {}", id);
        walletRepository.deleteById(id);
    }
}
