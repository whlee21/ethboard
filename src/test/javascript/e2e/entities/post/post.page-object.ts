import { element, by, ElementFinder } from 'protractor';

export class PostComponentsPage {
    createButton = element(by.id('jh-create-entity'));
    deleteButtons = element.all(by.css('jhi-post div table .btn-danger'));
    title = element.all(by.css('jhi-post div h2#page-heading span')).first();

    async clickOnCreateButton() {
        await this.createButton.click();
    }

    async clickOnLastDeleteButton() {
        await this.deleteButtons.last().click();
    }

    async countDeleteButtons() {
        return this.deleteButtons.count();
    }

    async getTitle() {
        return this.title.getAttribute('jhiTranslate');
    }
}

export class PostUpdatePage {
    pageTitle = element(by.id('jhi-post-heading'));
    saveButton = element(by.id('save-entity'));
    cancelButton = element(by.id('cancel-save'));
    titleInput = element(by.id('field_title'));
    contentInput = element(by.id('field_content'));
    ownerNameInput = element(by.id('field_ownerName'));
    ownerAccountInput = element(by.id('field_ownerAccount'));

    async getPageTitle() {
        return this.pageTitle.getAttribute('jhiTranslate');
    }

    async setTitleInput(title) {
        await this.titleInput.sendKeys(title);
    }

    async getTitleInput() {
        return this.titleInput.getAttribute('value');
    }

    async setContentInput(content) {
        await this.contentInput.sendKeys(content);
    }

    async getContentInput() {
        return this.contentInput.getAttribute('value');
    }

    async setOwnerNameInput(ownerName) {
        await this.ownerNameInput.sendKeys(ownerName);
    }

    async getOwnerNameInput() {
        return this.ownerNameInput.getAttribute('value');
    }

    async setOwnerAccountInput(ownerAccount) {
        await this.ownerAccountInput.sendKeys(ownerAccount);
    }

    async getOwnerAccountInput() {
        return this.ownerAccountInput.getAttribute('value');
    }

    async save() {
        await this.saveButton.click();
    }

    async cancel() {
        await this.cancelButton.click();
    }

    getSaveButton(): ElementFinder {
        return this.saveButton;
    }
}

export class PostDeleteDialog {
    private dialogTitle = element(by.id('jhi-delete-post-heading'));
    private confirmButton = element(by.id('jhi-confirm-delete-post'));

    async getDialogTitle() {
        return this.dialogTitle.getAttribute('jhiTranslate');
    }

    async clickOnConfirmButton() {
        await this.confirmButton.click();
    }
}
