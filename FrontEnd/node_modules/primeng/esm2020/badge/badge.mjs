import { CommonModule } from '@angular/common';
import { ChangeDetectionStrategy, Component, Directive, Input, NgModule, ViewEncapsulation } from '@angular/core';
import { SharedModule } from 'primeng/api';
import { DomHandler } from 'primeng/dom';
import { UniqueComponentId } from 'primeng/utils';
import * as i0 from "@angular/core";
import * as i1 from "@angular/common";
export class BadgeDirective {
    constructor(el) {
        this.el = el;
        this.iconPos = 'left';
        this._disabled = false;
    }
    get disabled() {
        return this._disabled;
    }
    set disabled(val) {
        this._disabled = val;
    }
    ngAfterViewInit() {
        this.id = UniqueComponentId() + '_badge';
        let el = this.el.nativeElement.nodeName.indexOf('-') != -1 ? this.el.nativeElement.firstChild : this.el.nativeElement;
        if (this._disabled) {
            return null;
        }
        let badge = document.createElement('span');
        badge.id = this.id;
        badge.className = 'p-badge p-component';
        if (this.severity) {
            DomHandler.addClass(badge, 'p-badge-' + this.severity);
        }
        if (this.value != null) {
            badge.appendChild(document.createTextNode(this.value));
            if (String(this.value).length === 1) {
                DomHandler.addClass(badge, 'p-badge-no-gutter');
            }
        }
        else {
            DomHandler.addClass(badge, 'p-badge-dot');
        }
        DomHandler.addClass(el, 'p-overlay-badge');
        el.appendChild(badge);
        this.initialized = true;
    }
    get value() {
        return this._value;
    }
    set value(val) {
        if (val !== this._value) {
            this._value = val;
            if (this.initialized) {
                let badge = document.getElementById(this.id);
                if (this._value) {
                    if (DomHandler.hasClass(badge, 'p-badge-dot'))
                        DomHandler.removeClass(badge, 'p-badge-dot');
                    if (String(this._value).length === 1) {
                        DomHandler.addClass(badge, 'p-badge-no-gutter');
                    }
                    else {
                        DomHandler.removeClass(badge, 'p-badge-no-gutter');
                    }
                }
                else if (!this._value && !DomHandler.hasClass(badge, 'p-badge-dot')) {
                    DomHandler.addClass(badge, 'p-badge-dot');
                }
                badge.innerHTML = '';
                badge.appendChild(document.createTextNode(this._value));
            }
        }
    }
    ngOnDestroy() {
        this.initialized = false;
    }
}
BadgeDirective.ɵfac = i0.ɵɵngDeclareFactory({ minVersion: "12.0.0", version: "14.0.7", ngImport: i0, type: BadgeDirective, deps: [{ token: i0.ElementRef }], target: i0.ɵɵFactoryTarget.Directive });
BadgeDirective.ɵdir = i0.ɵɵngDeclareDirective({ minVersion: "14.0.0", version: "14.0.7", type: BadgeDirective, selector: "[pBadge]", inputs: { iconPos: "iconPos", disabled: ["badgeDisabled", "disabled"], value: "value", severity: "severity" }, host: { classAttribute: "p-element" }, ngImport: i0 });
i0.ɵɵngDeclareClassMetadata({ minVersion: "12.0.0", version: "14.0.7", ngImport: i0, type: BadgeDirective, decorators: [{
            type: Directive,
            args: [{
                    selector: '[pBadge]',
                    host: {
                        class: 'p-element'
                    }
                }]
        }], ctorParameters: function () { return [{ type: i0.ElementRef }]; }, propDecorators: { iconPos: [{
                type: Input
            }], disabled: [{
                type: Input,
                args: ['badgeDisabled']
            }], value: [{
                type: Input
            }], severity: [{
                type: Input
            }] } });
export class Badge {
    constructor() {
        this.badgeDisabled = false;
    }
    containerClass() {
        return {
            'p-badge p-component': true,
            'p-badge-no-gutter': this.value != undefined && String(this.value).length === 1,
            'p-badge-lg': this.size === 'large',
            'p-badge-xl': this.size === 'xlarge',
            'p-badge-info': this.severity === 'info',
            'p-badge-success': this.severity === 'success',
            'p-badge-warning': this.severity === 'warning',
            'p-badge-danger': this.severity === 'danger'
        };
    }
}
Badge.ɵfac = i0.ɵɵngDeclareFactory({ minVersion: "12.0.0", version: "14.0.7", ngImport: i0, type: Badge, deps: [], target: i0.ɵɵFactoryTarget.Component });
Badge.ɵcmp = i0.ɵɵngDeclareComponent({ minVersion: "14.0.0", version: "14.0.7", type: Badge, selector: "p-badge", inputs: { styleClass: "styleClass", style: "style", size: "size", severity: "severity", value: "value", badgeDisabled: "badgeDisabled" }, host: { classAttribute: "p-element" }, ngImport: i0, template: ` <span *ngIf="!badgeDisabled" [ngClass]="containerClass()" [class]="styleClass" [ngStyle]="style">{{ value }}</span> `, isInline: true, styles: [".p-badge{display:inline-block;border-radius:10px;text-align:center;padding:0 .5rem}.p-overlay-badge{position:relative}.p-overlay-badge .p-badge{position:absolute;top:0;right:0;transform:translate(50%,-50%);transform-origin:100% 0;margin:0}.p-badge-dot{width:.5rem;min-width:.5rem;height:.5rem;border-radius:50%;padding:0}.p-badge-no-gutter{padding:0;border-radius:50%}\n"], dependencies: [{ kind: "directive", type: i1.NgClass, selector: "[ngClass]", inputs: ["class", "ngClass"] }, { kind: "directive", type: i1.NgIf, selector: "[ngIf]", inputs: ["ngIf", "ngIfThen", "ngIfElse"] }, { kind: "directive", type: i1.NgStyle, selector: "[ngStyle]", inputs: ["ngStyle"] }], changeDetection: i0.ChangeDetectionStrategy.OnPush, encapsulation: i0.ViewEncapsulation.None });
i0.ɵɵngDeclareClassMetadata({ minVersion: "12.0.0", version: "14.0.7", ngImport: i0, type: Badge, decorators: [{
            type: Component,
            args: [{ selector: 'p-badge', template: ` <span *ngIf="!badgeDisabled" [ngClass]="containerClass()" [class]="styleClass" [ngStyle]="style">{{ value }}</span> `, changeDetection: ChangeDetectionStrategy.OnPush, encapsulation: ViewEncapsulation.None, host: {
                        class: 'p-element'
                    }, styles: [".p-badge{display:inline-block;border-radius:10px;text-align:center;padding:0 .5rem}.p-overlay-badge{position:relative}.p-overlay-badge .p-badge{position:absolute;top:0;right:0;transform:translate(50%,-50%);transform-origin:100% 0;margin:0}.p-badge-dot{width:.5rem;min-width:.5rem;height:.5rem;border-radius:50%;padding:0}.p-badge-no-gutter{padding:0;border-radius:50%}\n"] }]
        }], propDecorators: { styleClass: [{
                type: Input
            }], style: [{
                type: Input
            }], size: [{
                type: Input
            }], severity: [{
                type: Input
            }], value: [{
                type: Input
            }], badgeDisabled: [{
                type: Input
            }] } });
export class BadgeModule {
}
BadgeModule.ɵfac = i0.ɵɵngDeclareFactory({ minVersion: "12.0.0", version: "14.0.7", ngImport: i0, type: BadgeModule, deps: [], target: i0.ɵɵFactoryTarget.NgModule });
BadgeModule.ɵmod = i0.ɵɵngDeclareNgModule({ minVersion: "14.0.0", version: "14.0.7", ngImport: i0, type: BadgeModule, declarations: [Badge, BadgeDirective], imports: [CommonModule], exports: [Badge, BadgeDirective, SharedModule] });
BadgeModule.ɵinj = i0.ɵɵngDeclareInjector({ minVersion: "12.0.0", version: "14.0.7", ngImport: i0, type: BadgeModule, imports: [CommonModule, SharedModule] });
i0.ɵɵngDeclareClassMetadata({ minVersion: "12.0.0", version: "14.0.7", ngImport: i0, type: BadgeModule, decorators: [{
            type: NgModule,
            args: [{
                    imports: [CommonModule],
                    exports: [Badge, BadgeDirective, SharedModule],
                    declarations: [Badge, BadgeDirective]
                }]
        }] });
//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiYmFkZ2UuanMiLCJzb3VyY2VSb290IjoiIiwic291cmNlcyI6WyIuLi8uLi8uLi9zcmMvYXBwL2NvbXBvbmVudHMvYmFkZ2UvYmFkZ2UudHMiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUEsT0FBTyxFQUFFLFlBQVksRUFBRSxNQUFNLGlCQUFpQixDQUFDO0FBQy9DLE9BQU8sRUFBaUIsdUJBQXVCLEVBQUUsU0FBUyxFQUFFLFNBQVMsRUFBYyxLQUFLLEVBQUUsUUFBUSxFQUFhLGlCQUFpQixFQUFFLE1BQU0sZUFBZSxDQUFDO0FBQ3hKLE9BQU8sRUFBRSxZQUFZLEVBQUUsTUFBTSxhQUFhLENBQUM7QUFDM0MsT0FBTyxFQUFFLFVBQVUsRUFBRSxNQUFNLGFBQWEsQ0FBQztBQUN6QyxPQUFPLEVBQUUsaUJBQWlCLEVBQUUsTUFBTSxlQUFlLENBQUM7OztBQVVsRCxNQUFNLE9BQU8sY0FBYztJQWtCdkIsWUFBbUIsRUFBYztRQUFkLE9BQUUsR0FBRixFQUFFLENBQVk7UUFqQnhCLFlBQU8sR0FBK0IsTUFBTSxDQUFDO1FBZXRELGNBQVMsR0FBWSxLQUFLLENBQUM7SUFFUyxDQUFDO0lBZnJDLElBQTRCLFFBQVE7UUFDaEMsT0FBTyxJQUFJLENBQUMsU0FBUyxDQUFDO0lBQzFCLENBQUM7SUFDRCxJQUFJLFFBQVEsQ0FBQyxHQUFZO1FBQ3JCLElBQUksQ0FBQyxTQUFTLEdBQUcsR0FBRyxDQUFDO0lBQ3pCLENBQUM7SUFZRCxlQUFlO1FBQ1gsSUFBSSxDQUFDLEVBQUUsR0FBRyxpQkFBaUIsRUFBRSxHQUFHLFFBQVEsQ0FBQztRQUN6QyxJQUFJLEVBQUUsR0FBRyxJQUFJLENBQUMsRUFBRSxDQUFDLGFBQWEsQ0FBQyxRQUFRLENBQUMsT0FBTyxDQUFDLEdBQUcsQ0FBQyxJQUFJLENBQUMsQ0FBQyxDQUFDLENBQUMsQ0FBQyxJQUFJLENBQUMsRUFBRSxDQUFDLGFBQWEsQ0FBQyxVQUFVLENBQUMsQ0FBQyxDQUFDLElBQUksQ0FBQyxFQUFFLENBQUMsYUFBYSxD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TyxXQUFXOzt3R0FBWCxXQUFXO3lHQUFYLFdBQVcsaUJBaENYLEtBQUssRUFsR0wsY0FBYyxhQThIYixZQUFZLGFBNUJiLEtBQUssRUFsR0wsY0FBYyxFQStIVSxZQUFZO3lHQUdwQyxXQUFXLFlBSlYsWUFBWSxFQUNXLFlBQVk7MkZBR3BDLFdBQVc7a0JBTHZCLFFBQVE7bUJBQUM7b0JBQ04sT0FBTyxFQUFFLENBQUMsWUFBWSxDQUFDO29CQUN2QixPQUFPLEVBQUUsQ0FBQyxLQUFLLEVBQUUsY0FBYyxFQUFFLFlBQVksQ0FBQztvQkFDOUMsWUFBWSxFQUFFLENBQUMsS0FBSyxFQUFFLGNBQWMsQ0FBQztpQkFDeEMiLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQgeyBDb21tb25Nb2R1bGUgfSBmcm9tICdAYW5ndWxhci9jb21tb24nO1xuaW1wb3J0IHsgQWZ0ZXJWaWV3SW5pdCwgQ2hhbmdlRGV0ZWN0aW9uU3RyYXRlZ3ksIENvbXBvbmVudCwgRGlyZWN0aXZlLCBFbGVtZW50UmVmLCBJbnB1dCwgTmdNb2R1bGUsIE9uRGVzdHJveSwgVmlld0VuY2Fwc3VsYXRpb24gfSBmcm9tICdAYW5ndWxhci9jb3JlJztcbmltcG9ydCB7IFNoYXJlZE1vZHVsZSB9IGZyb20gJ3ByaW1lbmcvYXBpJztcbmltcG9ydCB7IERvbUhhbmRsZXIgfSBmcm9tICdwcmltZW5nL2RvbSc7XG5pbXBvcnQgeyBVbmlxdWVDb21wb25lbnRJZCB9IGZyb20gJ3ByaW1lbmcvdXRpbHMnO1xuXG50eXBlIEJhZGdlRGlyZWN0aXZlSWNvblBvc2l0aW9uID0gJ2xlZnQnIHwgJ3JpZ2h0JyB8ICd0b3AnIHwgJ2JvdHRvbSc7XG5cbkBEaXJlY3RpdmUoe1xuICAgIHNlbGVjdG9yOiAnW3BCYWRnZV0nLFxuICAgIGhvc3Q6IHtcbiAgICAgICAgY2xhc3M6ICdwLWVsZW1lbnQnXG4gICAgfVxufSlcbmV4cG9ydCBjbGFzcyBCYWRnZURpcmVjdGl2ZSBpbXBsZW1lbnRzIEFmdGVyVmlld0luaXQsIE9uRGVzdHJveSB7XG4gICAgQElucHV0KCkgaWNvblBvczogQmFkZ2VEaXJlY3RpdmVJY29uUG9zaXRpb24gPSAnbGVmdCc7XG5cbiAgICBASW5wdXQoJ2JhZGdlRGlzYWJsZWQnKSBnZXQgZGlzYWJsZWQoKTogYm9vbGVhbiB7XG4gICAgICAgIHJldHVybiB0aGlzLl9kaXNhYmxlZDtcbiAgICB9XG4gICAgc2V0IGRpc2FibGVkKHZhbDogYm9vbGVhbikge1xuICAgICAgICB0aGlzLl9kaXNhYmxlZCA9IHZhbDtcbiAgICB9XG5cbiAgICBwdWJsaWMgX3ZhbHVlOiBzdHJpbmc7XG5cbiAgICBwdWJsaWMgaW5pdGlhbGl6ZWQ6IGJvb2xlYW47XG5cbiAgICBwcml2YXRlIGlkOiBzdHJpbmc7XG5cbiAgICBfZGlzYWJsZWQ6IGJvb2xlYW4gPSBmYWxzZTtcblxuICAgIGNvbnN0cnVjdG9yKHB1YmxpYyBlbDogRWxlbWVudFJlZikge31cblxuICAgIG5nQWZ0ZXJWaWV3SW5pdCgpIHtcbiAgICAgICAgdGhpcy5pZCA9IFVuaXF1ZUNvbXBvbmVudElkKCkgKyAnX2JhZGdlJztcbiAgICAgICAgbGV0IGVsID0gdGhpcy5lbC5uYXRpdmVFbGVtZW50Lm5vZGVOYW1lLmluZGV4T2YoJy0nKSAhPSAtMSA/IHRoaXMuZWwubmF0aXZlRWxlbWVudC5maXJzdENoaWxkIDogdGhpcy5lbC5uYXRpdmVFbGVtZW50O1xuXG4gICAgICAgIGlmICh0aGlzLl9kaXNhYmxlZCkge1xuICAgICAgICAgICAgcmV0dXJuIG51bGw7XG4gICAgICAgIH1cblxuICAgICAgICBsZXQgYmFkZ2UgPSBkb2N1bWVudC5jcmVhdGVFbGVtZW50KCdzcGFuJyk7XG4gICAgICAgIGJhZGdlLmlkID0gdGhpcy5pZDtcbiAgICAgICAgYmFkZ2UuY2xhc3NOYW1lID0gJ3AtYmFkZ2UgcC1jb21wb25lbnQnO1xuXG4gICAgICAgIGlmICh0aGlzLnNldmVyaXR5KSB7XG4gICAgICAgICAgICBEb21IYW5kbGVyLmFkZENsYXNzKGJhZGdlLCAncC1iYWRnZS0nICsgdGhpcy5zZXZlcml0eSk7XG4gICAgICAgIH1cblxuICAgICAgICBpZiAodGhpcy52YWx1ZSAhPSBudWxsKSB7XG4gICAgICAgICAgICBiYWRnZS5hcHBlbmRDaGlsZChkb2N1bWVudC5jcmVhdGVUZXh0Tm9kZSh0aGlzLnZhbHVlKSk7XG5cbiAgICAgICAgICAgIGlmIChTdHJpbmcodGhpcy52YWx1ZSkubGVuZ3RoID09PSAxKSB7XG4gICAgICAgICAgICAgICAgRG9tSGFuZGxlci5hZGRDbGFzcyhiYWRnZSwgJ3AtYmFkZ2Utbm8tZ3V0dGVyJyk7XG4gICAgICAgICAgICB9XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBEb21IYW5kbGVyLmFkZENsYXNzKGJhZGdlLCAncC1iYWRnZS1kb3QnKTtcbiAgICAgICAgfVxuXG4gICAgICAgIERvbUhhbmRsZXIuYWRkQ2xhc3MoZWwsICdwLW92ZXJsYXktYmFkZ2UnKTtcbiAgICAgICAgZWwuYXBwZW5kQ2hpbGQoYmFkZ2UpO1xuXG4gICAgICAgIHRoaXMuaW5pdGlhbGl6ZWQgPSB0cnVlO1xuICAgIH1cblxuICAgIEBJbnB1dCgpIGdldCB2YWx1ZSgpOiBzdHJpbmcge1xuICAgICAgICByZXR1cm4gdGhpcy5fdmFsdWU7XG4gICAgfVxuXG4gICAgc2V0IHZhbHVlKHZhbDogc3RyaW5nKSB7XG4gICAgICAgIGlmICh2YWwgIT09IHRoaXMuX3ZhbHVlKSB7XG4gICAgICAgICAgICB0aGlzLl92YWx1ZSA9IHZhbDtcblxuICAgICAgICAgICAgaWYgKHRoaXMuaW5pdGlhbGl6ZWQpIHtcbiAgICAgICAgICAgICAgICBsZXQgYmFkZ2UgPSBkb2N1bWVudC5nZXRFbGVtZW50QnlJZCh0aGlzLmlkKTtcblxuICAgICAgICAgICAgICAgIGlmICh0aGlzLl92YWx1ZSkge1xuICAgICAgICAgICAgICAgICAgICBpZiAoRG9tSGFuZGxlci5oYXNDbGFzcyhiYWRnZSwgJ3AtYmFkZ2UtZG90JykpIERvbUhhbmRsZXIucmVtb3ZlQ2xhc3MoYmFkZ2UsICdwLWJhZGdlLWRvdCcpO1xuXG4gICAgICAgICAgICAgICAgICAgIGlmIChTdHJpbmcodGhpcy5fdmFsdWUpLmxlbmd0aCA9PT0gMSkge1xuICAgICAgICAgICAgICAgICAgICAgICAgRG9tSGFuZGxlci5hZGRDbGFzcyhiYWRnZSwgJ3AtYmFkZ2Utbm8tZ3V0dGVyJyk7XG4gICAgICAgICAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgICAgICAgICBEb21IYW5kbGVyLnJlbW92ZUNsYXNzKGJhZGdlLCAncC1iYWRnZS1uby1ndXR0ZXInKTtcbiAgICAgICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIH0gZWxzZSBpZiAoIXRoaXMuX3ZhbHVlICYmICFEb21IYW5kbGVyLmhhc0NsYXNzKGJhZGdlLCAncC1iYWRnZS1kb3QnKSkge1xuICAgICAgICAgICAgICAgICAgICBEb21IYW5kbGVyLmFkZENsYXNzKGJhZGdlLCAncC1iYWRnZS1kb3QnKTtcbiAgICAgICAgICAgICAgICB9XG5cbiAgICAgICAgICAgICAgICBiYWRnZS5pbm5lckhUTUwgPSAnJztcbiAgICAgICAgICAgICAgICBiYWRnZS5hcHBlbmRDaGlsZChkb2N1bWVudC5jcmVhdGVUZXh0Tm9kZSh0aGlzLl92YWx1ZSkpO1xuICAgICAgICAgICAgfVxuICAgICAgICB9XG4gICAgfVxuXG4gICAgQElucHV0KCkgc2V2ZXJpdHk6IHN0cmluZztcblxuICAgIG5nT25EZXN0cm95KCkge1xuICAgICAgICB0aGlzLmluaXRpYWxpemVkID0gZmFsc2U7XG4gICAgfVxufVxuXG5AQ29tcG9uZW50KHtcbiAgICBzZWxlY3RvcjogJ3AtYmFkZ2UnLFxuICAgIHRlbXBsYXRlOiBgIDxzcGFuICpuZ0lmPVwiIWJhZGdlRGlzYWJsZWRcIiBbbmdDbGFzc109XCJjb250YWluZXJDbGFzcygpXCIgW2NsYXNzXT1cInN0eWxlQ2xhc3NcIiBbbmdTdHlsZV09XCJzdHlsZVwiPnt7IHZhbHVlIH19PC9zcGFuPiBgLFxuICAgIGNoYW5nZURldGVjdGlvbjogQ2hhbmdlRGV0ZWN0aW9uU3RyYXRlZ3kuT25QdXNoLFxuICAgIGVuY2Fwc3VsYXRpb246IFZpZXdFbmNhcHN1bGF0aW9uLk5vbmUsXG4gICAgc3R5bGVVcmxzOiBbJy4vYmFkZ2UuY3NzJ10sXG4gICAgaG9zdDoge1xuICAgICAgICBjbGFzczogJ3AtZWxlbWVudCdcbiAgICB9XG59KVxuZXhwb3J0IGNsYXNzIEJhZGdlIHtcbiAgICBASW5wdXQoKSBzdHlsZUNsYXNzOiBzdHJpbmc7XG5cbiAgICBASW5wdXQoKSBzdHlsZTogYW55O1xuXG4gICAgQElucHV0KCkgc2l6ZTogc3RyaW5nO1xuXG4gICAgQElucHV0KCkgc2V2ZXJpdHk6IHN0cmluZztcblxuICAgIEBJbnB1dCgpIHZhbHVlOiBzdHJpbmc7XG5cbiAgICBASW5wdXQoKSBiYWRnZURpc2FibGVkOiBib29sZWFuID0gZmFsc2U7XG5cbiAgICBjb250YWluZXJDbGFzcygpIHtcbiAgICAgICAgcmV0dXJuIHtcbiAgICAgICAgICAgICdwLWJhZGdlIHAtY29tcG9uZW50JzogdHJ1ZSxcbiAgICAgICAgICAgICdwLWJhZGdlLW5vLWd1dHRlcic6IHRoaXMudmFsdWUgIT0gdW5kZWZpbmVkICYmIFN0cmluZyh0aGlzLnZhbHVlKS5sZW5ndGggPT09IDEsXG4gICAgICAgICAgICAncC1iYWRnZS1sZyc6IHRoaXMuc2l6ZSA9PT0gJ2xhcmdlJyxcbiAgICAgICAgICAgICdwLWJhZGdlLXhsJzogdGhpcy5zaXplID09PSAneGxhcmdlJyxcbiAgICAgICAgICAgICdwLWJhZGdlLWluZm8nOiB0aGlzLnNldmVyaXR5ID09PSAnaW5mbycsXG4gICAgICAgICAgICAncC1iYWRnZS1zdWNjZXNzJzogdGhpcy5zZXZlcml0eSA9PT0gJ3N1Y2Nlc3MnLFxuICAgICAgICAgICAgJ3AtYmFkZ2Utd2FybmluZyc6IHRoaXMuc2V2ZXJpdHkgPT09ICd3YXJuaW5nJyxcbiAgICAgICAgICAgICdwLWJhZGdlLWRhbmdlcic6IHRoaXMuc2V2ZXJpdHkgPT09ICdkYW5nZXInXG4gICAgICAgIH07XG4gICAgfVxufVxuXG5ATmdNb2R1bGUoe1xuICAgIGltcG9ydHM6IFtDb21tb25Nb2R1bGVdLFxuICAgIGV4cG9ydHM6IFtCYWRnZSwgQmFkZ2VEaXJlY3RpdmUsIFNoYXJlZE1vZHVsZV0sXG4gICAgZGVjbGFyYXRpb25zOiBbQmFkZ2UsIEJhZGdlRGlyZWN0aXZlXVxufSlcbmV4cG9ydCBjbGFzcyBCYWRnZU1vZHVsZSB7fVxuIl19