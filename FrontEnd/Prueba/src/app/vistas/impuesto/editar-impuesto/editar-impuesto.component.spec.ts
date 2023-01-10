import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarImpuestoComponent } from './editar-impuesto.component';

describe('EditarImpuestoComponent', () => {
  let component: EditarImpuestoComponent;
  let fixture: ComponentFixture<EditarImpuestoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditarImpuestoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditarImpuestoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
