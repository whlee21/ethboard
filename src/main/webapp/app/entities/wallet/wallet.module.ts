import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EthboardSharedModule } from 'app/shared';
import { EthboardAdminModule } from 'app/admin/admin.module';
import {
    WalletComponent,
    WalletDetailComponent,
    WalletUpdateComponent,
    WalletDeletePopupComponent,
    WalletDeleteDialogComponent,
    walletRoute,
    walletPopupRoute
} from './';

const ENTITY_STATES = [...walletRoute, ...walletPopupRoute];

@NgModule({
    imports: [EthboardSharedModule, EthboardAdminModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [WalletComponent, WalletDetailComponent, WalletUpdateComponent, WalletDeleteDialogComponent, WalletDeletePopupComponent],
    entryComponents: [WalletComponent, WalletUpdateComponent, WalletDeleteDialogComponent, WalletDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EthboardWalletModule {}
