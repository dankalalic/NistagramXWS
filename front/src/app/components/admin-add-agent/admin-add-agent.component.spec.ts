import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAddAgentComponent } from './admin-add-agent.component';

describe('AdminAddAgentComponent', () => {
  let component: AdminAddAgentComponent;
  let fixture: ComponentFixture<AdminAddAgentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminAddAgentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAddAgentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
